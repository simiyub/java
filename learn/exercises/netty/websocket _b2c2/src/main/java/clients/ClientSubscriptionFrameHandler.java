package clients;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.util.Locale;

/**
 * Handles the frames from the websocket communication with client
 * */
public class ClientSubscriptionFrameHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame)
            {
        if(webSocketFrame instanceof TextWebSocketFrame){

            String request = ((TextWebSocketFrame) webSocketFrame).text();
            channelHandlerContext.channel().writeAndFlush(
                    new TextWebSocketFrame(request.toUpperCase(Locale.US)));
        }
        else{
            throw new UnsupportedOperationException("unsupported frame type"+webSocketFrame.getClass().getName());
        }

    }
}
