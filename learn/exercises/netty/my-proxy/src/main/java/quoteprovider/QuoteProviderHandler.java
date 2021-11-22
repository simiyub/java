package quoteprovider;

import io.netty.channel.*;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import util.Util;

/**
 * Handles interaction with B2C2, handshake and websocket quote response
 * */

public class QuoteProviderHandler extends SimpleChannelInboundHandler<WebSocketFrame>  {

//    private final Channel inChannel;
    boolean run = false;
//    private final WebSocketClientHandshaker handshaker;
    private ChannelPromise handshakeFuture;

    public QuoteProviderHandler() {
//        this.handshaker = handshaker;
//        this.inChannel = inChannel;
    }

    private WebSocketClientHandshaker handShaker(){

        DefaultHttpHeaders authorisedHeader = new DefaultHttpHeaders();
        authorisedHeader.add("Authorization", Util.getToken());

       return WebSocketClientHandshakerFactory.newHandshaker(
                        Util.getRemoteURI(), WebSocketVersion.V13, null, true, authorisedHeader);
    }

    public ChannelFuture handshakeFuture() {
        return handshakeFuture;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {

        handshakeFuture = ctx.newPromise();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("Remote channel active.");
        handShaker().handshake(ctx.channel());
        ctx.read();
        ///1052 - 08-06
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) {

        System.out.println("WebSocket Client disconnected!");
    }

    @Override
    public void channelRead0(ChannelHandlerContext context, WebSocketFrame message){
        Channel channel = context.channel();

        WebSocketFrame frame = (WebSocketFrame) message;
        channel.writeAndFlush(frame).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("success channel read");
                    channel.read();
                }
                else{
                    System.out.println("failed channel read");
                    //channel.close();
                }
            }
        });

        if (!handShaker().isHandshakeComplete()) {
            try {
                handShaker().finishHandshake(channel, (FullHttpResponse) message);
                System.out.println("Finished handshake. WebSocket client connected!");
                handshakeFuture.setSuccess();
            } catch (WebSocketHandshakeException e) {
                System.out.println("WebSocket client failed to connect");
                handshakeFuture.setFailure(e);
            }
            return;
        }

        if (message instanceof FullHttpResponse) {
            FullHttpResponse response = (FullHttpResponse) message;
            throw new IllegalStateException(
                    "Unexpected FullHttpResponse (getStatus=" + response.status() +
                            ", content=" + response.content().toString(CharsetUtil.UTF_8) + ')');
        }


        if (frame instanceof TextWebSocketFrame) {
            String content = ((TextWebSocketFrame) frame).text();
            System.out.println(content);

            //Gson gson = new Gson();
            //Subscription subscription = gson.fromJson(content,Subscription.class);
            //store subscription request to be updated on response from quote provider
           // System.out.println(subscription.toString());

        }
        else if (frame instanceof CloseWebSocketFrame) {
            channel.close();
            System.out.println("Received closing request. Closed");
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        if (!handshakeFuture.isDone()) {
            handshakeFuture.setFailure(cause);
        }
        ctx.close();
    }
}
