import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOption;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;

import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;

public class HexDumpProxyFrontendHandler extends ChannelInboundHandlerAdapter {

    private static final String WEB_SOCKET_PATH = "/websocket";
    private static final boolean SSL = System.getProperty("ssl") != null;
    private final String remoteHost;
    private final int remotePort;
    private WebSocketServerHandshaker handShaker;

    // As we use inboundChannel.eventLoop() when building the Bootstrap this does not need to be volatile as
    // the outboundChannel will use the same EventLoop (and therefore Thread) as the inboundChannel.
    private Channel outboundChannel;

    public HexDumpProxyFrontendHandler(String remoteHost, int remotePort) {
        this.remoteHost = remoteHost;
        this.remotePort = remotePort;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        final Channel inboundChannel = ctx.channel();

        // Start the connection attempt.
        Bootstrap b = new Bootstrap();
        b.group(inboundChannel.eventLoop())
                .channel(ctx.channel().getClass())
                .handler(new HexDumpProxyBackendHandler(inboundChannel))
                .option(ChannelOption.AUTO_READ, false);
        ChannelFuture f = b.connect(remoteHost, remotePort);
        outboundChannel = f.channel();
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                if (future.isSuccess()) {
                    // connection complete start to read first data
                    System.out.println("Front end active");
                    inboundChannel.read();
                } else {
                    // Close the connection if the connection attempt has failed.
                    inboundChannel.close();
                }
            }
        });
    }

    @Override
    public void channelRead(final ChannelHandlerContext context, Object message) {
        if (outboundChannel.isActive()) {

            if(message instanceof FullHttpRequest) {
                handShaker = handleHandShakeRequest(context, (FullHttpRequest) message);
            }
            outboundChannel.writeAndFlush(message).addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) {
                    if (future.isSuccess()) {
                        // was able to flush out data, start to read the next chunk
                        ByteBuf in = (ByteBuf) message;
                        byte[] req = new byte[in.readableBytes()];
                        in.readBytes(req);
                        String body = new String(req, CharsetUtil.UTF_8)    ;
                        System.out.println("Front server:"+body);

                        context.channel().read();
                    } else {
                        future.channel().close();
                    }
                }
            });
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        if (outboundChannel != null) {
            closeOnFlush(outboundChannel);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        closeOnFlush(ctx.channel());
    }

    /**
     * Closes the specified channel after all queued write requests are flushed.
     */
    static void closeOnFlush(Channel ch) {
        if (ch.isActive()) {
            ch.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
    }


    private WebSocketServerHandshaker handleHandShakeRequest(ChannelHandlerContext channelHandlerContext, FullHttpRequest request) {

        // Handle a bad request.
        if (!request.decoderResult().isSuccess()) {
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(request.protocolVersion(), BAD_REQUEST,
                    channelHandlerContext.alloc().buffer(0));

            sendHttpResponse(response);
            updateListener(channelHandlerContext, request, response);
        }

        // Allow only GET methods.
        if (!GET.equals(request.method())) {
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(request.protocolVersion(), FORBIDDEN,
                    channelHandlerContext.alloc().buffer(0));

            sendHttpResponse(response);
            updateListener(channelHandlerContext, request, response);
        }

        // Handshake
        return getHandShaker(channelHandlerContext, request);

    }

    private static void sendHttpResponse( FullHttpResponse response) {

        if (response.status().code() != 200) {
            ByteBufUtil.writeUtf8(response.content(), response.status().toString());
            HttpUtil.setContentLength(response, response.content().readableBytes());
        }
    }

    private static void updateListener(ChannelHandlerContext channelHandlerContext, FullHttpRequest request, FullHttpResponse response) {
        // move this out
        boolean keepAlive = HttpUtil.isKeepAlive(request) && response.status().code() == 200;
        HttpUtil.setKeepAlive(response, keepAlive);
        ChannelFuture future = channelHandlerContext.write(response);
        if (!keepAlive) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    private WebSocketServerHandshaker getHandShaker(ChannelHandlerContext channelHandlerContext, FullHttpRequest request) {
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                getWebSocketLocation(request), null, true, 5 * 1024 * 1024);
        WebSocketServerHandshaker handShaker = wsFactory.newHandshaker(request);

        if (handShaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(channelHandlerContext.channel());
        } else {
            handShaker.handshake(channelHandlerContext.channel(), request);
        }
        return handShaker;
    }

    private static String getWebSocketLocation(FullHttpRequest req) {
        return   (SSL? "wss://": "ws://") + req.headers().get(HttpHeaderNames.HOST) + WEB_SOCKET_PATH;

    }
}
