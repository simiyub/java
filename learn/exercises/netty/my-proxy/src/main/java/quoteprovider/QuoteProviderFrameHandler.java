package quoteprovider;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Locale;

public class QuoteProviderFrameHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
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
