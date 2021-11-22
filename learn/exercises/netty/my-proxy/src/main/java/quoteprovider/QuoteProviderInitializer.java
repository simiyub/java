package quoteprovider;

import clients.ClientSubscriptionFrameHandler;
import clients.ClientSubscriptionHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import util.Util;

/**
 * Initialises pipeline for our client
 * */
public class QuoteProviderInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    public void initChannel(SocketChannel channel){
        ChannelPipeline pipeline = channel.pipeline();
        if(Util.serverSSLContext() !=null){
            pipeline.addLast(Util.serverSSLContext().newHandler(channel.alloc()));
        }
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(64*1024));
        pipeline.addLast(new QuoteProviderHandler());
        pipeline.addLast(new WebSocketServerCompressionHandler());
        pipeline.addLast(new WebSocketServerProtocolHandler(Util.getWebSocketPath(), null, true));
     //   pipeline.addLast(new ClientSubscriptionFrameHandler());


    }
}
