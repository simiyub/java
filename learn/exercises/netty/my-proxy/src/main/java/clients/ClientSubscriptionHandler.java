package clients;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import quoteprovider.QuoteProviderClient;
import quoteprovider.QuoteProviderFrameHandler;
import quoteprovider.QuoteProviderHandler;
import quoteprovider.QuoteProviderInitializer;
import util.Util;

import java.net.InetSocketAddress;
import java.util.Locale;

import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;

/**
 * Handles interaction with our client, handshake and websocket responses back
 * */

public class ClientSubscriptionHandler extends SimpleChannelInboundHandler<WebSocketFrame>{

    static final boolean SSL = System.getProperty("ssl") !=null ;
    private final String providerHost;
    private final int providerPort;
    private WebSocketServerHandshaker handShaker;
    private Channel outboundChannel;
    ChannelFuture providerFuture;

    public ClientSubscriptionHandler(String host, int port) {
        this.providerHost = host;
        this.providerPort = port;
    }


    private static String getWebSocketLocation(FullHttpRequest req) {
       return   (SSL? "wss://": "ws://") + req.headers().get(HttpHeaderNames.HOST) + Util.getWebSocketPath();

    }

    @Override
    public void channelRead0(ChannelHandlerContext channelHandlerContext, WebSocketFrame message) {
        if(providerFuture.isDone()){
            System.out.println("Provider future is done.");
        }
        if(message instanceof FullHttpRequest) {
            handShaker = handleHandShakeRequest(channelHandlerContext, (FullHttpRequest) message);
        }
        else if(message instanceof WebSocketFrame){

                        System.out.println(((WebSocketFrame) message).content());
            handleWebSocketFrame(channelHandlerContext, handShaker, (WebSocketFrame) message);

        }

    }





    @Override
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        if (outboundChannel != null) {
            closeOnFlush(outboundChannel);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
        cause.printStackTrace();
        context.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        if (outboundChannel != null) {
            closeOnFlush(outboundChannel);
        }
    }

    /**
     * Closes the specified channel after all queued write requests are flushed.
     */
    static void closeOnFlush(Channel ch) {
        if (ch.isActive()) {
            ch.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
    }

    /**
     * Handles handshake.
     * Future refactor to chain of responsibility * */
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

    private void handleWebSocketFrame(ChannelHandlerContext channelHandlerContext, WebSocketServerHandshaker handShaker, WebSocketFrame frame) {

        if (frame instanceof TextWebSocketFrame) {
//            QuoteProviderClient quoteProviderClient = new QuoteProviderClient();
//            quoteProviderClient
            System.out.println(((TextWebSocketFrame) frame).text());
//            try {
//                channelHandlerContext.write(frame);
//            }
//            catch (Exception exception){
//                exception.printStackTrace();
//            }

            if (outboundChannel.isActive()) {
                //frame.retain()+"received."
                outboundChannel.write(frame);
//                .addListener(new ChannelFutureListener() {
//                    @Override
//                    public void operationComplete(ChannelFuture future) {
//                        if (providerFuture.isSuccess()) {
//                            // was able to flush out data, start to read the next chunk
//                            System.out.println("websocket future success");
//                            channelHandlerContext.channel().read();
//                        } else {
//                            providerFuture.channel().close();
//                        }
//                    }
//                });
            }
        }
        else if (frame instanceof CloseWebSocketFrame && handShaker!=null) {
            handShaker.close(channelHandlerContext, (CloseWebSocketFrame) frame.retain());
        }

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

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        final Channel inboundChannel = ctx.channel();

        // Start the connection attempt.
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(ctx.channel().getClass())
                .handler(new LoggingHandler(LogLevel.INFO))
                .handler(new QuoteProviderInitializer())
                .group(inboundChannel.eventLoop());
                //.option(ChannelOption.AUTO_READ,false);


//                        QuoteProviderClient.handler())
//                .option(ChannelOption.AUTO_READ, false);
        providerFuture = bootstrap.connect(providerHost, providerPort);


//        outboundChannel = providerFuture.channel();
//        providerFuture.addListener((ChannelFutureListener) future -> {
//            if (future.isSuccess()) {
//                // connection complete start to read first data
//                System.out.println("Connected to quote provider.");
//                inboundChannel.read();
//            } else {
//                // Close the connection if the connection attempt has failed.
//                System.out.println("Could not connect to quote provider. closing..");
//                inboundChannel.close();
//            }
//        });

//        new SimpleChannelInboundHandler<WebSocketFrame>() {
//            ChannelFuture channelFuture;
//
//            @Override
//            public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception{
//                Bootstrap remoteBootstrap = new Bootstrap();
//                remoteBootstrap.channel(NioSocketChannel.class).handler(
//                        new SimpleChannelInboundHandler<WebSocketFrame>() {
//                            @Override
//                            protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
//                                System.out.println("Received data from remote server.");
//                            }
//                        }
//                );
//                remoteBootstrap.group(channelHandlerContext.channel().eventLoop());
//                channelFuture = remoteBootstrap.bind(new InetSocketAddress(Util.getRemoteURI().getHost(),Util.getRemoteURI().getPort()));
//            }
//
//            @Override
//            protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
//                if(channelFuture.isDone()) System.out.println("Channel read is done.");
//
//            }
//
//        }
    }






    }
