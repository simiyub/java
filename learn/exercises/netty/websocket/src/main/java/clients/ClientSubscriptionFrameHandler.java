package clients;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import quoteprovider.QuoteProviderClient;
import quoteprovider.QuoteProviderInitializer;

import javax.net.ssl.SSLException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Locale;

/**
 * Handles the frames from the websocket communication with client
 * */
public class ClientSubscriptionFrameHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

    private ChannelFuture connectionFuture;
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame)
            {
                if(connectionFuture.isDone()){
                    System.out.println("future done");
                }
        if(webSocketFrame instanceof TextWebSocketFrame){

            String request = ((TextWebSocketFrame) webSocketFrame).text();
            channelHandlerContext.channel().writeAndFlush(
                    new TextWebSocketFrame(request.toUpperCase(Locale.US)));
        }
        else{
            throw new UnsupportedOperationException("unsupported frame type"+webSocketFrame.getClass().getName());
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext context) throws SSLException, UnknownHostException, URISyntaxException {
        Bootstrap providerBootstrap = new Bootstrap();
        providerBootstrap.channel(NioSocketChannel.class).handler(
                new QuoteProviderInitializer()
        );
        providerBootstrap.group(context.channel().eventLoop());
        connectionFuture = providerBootstrap.connect(new InetSocketAddress(QuoteProviderClient.getURL(), QuoteProviderClient.getPort()));

    }
}
