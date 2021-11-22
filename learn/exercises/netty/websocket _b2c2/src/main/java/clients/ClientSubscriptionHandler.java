package clients;


import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import quoteprovider.QuoteProviderClient;

import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.*;

/**
 * Handles interaction with our client, handshake and websocket responses back
 * */

public class ClientSubscriptionHandler extends SimpleChannelInboundHandler<Object>{

    static final boolean SSL = System.getProperty("ssl") !=null ;
    private static final String WEBSOCKET_PATH = "/websocket";
    private WebSocketServerHandshaker handShaker;


    private static String getWebSocketLocation(FullHttpRequest req) {
        return (SSL? "wss://": "ws://") + req.headers().get(HttpHeaderNames.HOST) + WEBSOCKET_PATH;
    }

    @Override
    public void channelRead0(ChannelHandlerContext channelHandlerContext, Object message) {
        if(message instanceof FullHttpRequest) {
            handShaker = handleRequest(channelHandlerContext, (FullHttpRequest) message);
        }
        else if(message instanceof WebSocketFrame){
            System.out.println(((WebSocketFrame) message).content());
            handleWebSocketFrame(channelHandlerContext, handShaker, (WebSocketFrame) message);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
        cause.printStackTrace();
        context.close();
    }

    /**
     * Handles handshake.
     * Future refactor to chain of responsibility * */
    private WebSocketServerHandshaker handleRequest(ChannelHandlerContext channelHandlerContext, FullHttpRequest request) {

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
            channelHandlerContext.write(frame.retain());
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





    }
