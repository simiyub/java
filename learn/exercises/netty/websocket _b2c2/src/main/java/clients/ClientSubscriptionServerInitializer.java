package clients;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.ssl.SslContext;

/**
 * Initialises pipeline for our client
 * */
public class ClientSubscriptionServerInitializer extends ChannelInitializer<SocketChannel> {

    private static final String WEBSOCKET_PATH = "/websocket";
    private final SslContext SSLContext;

    public ClientSubscriptionServerInitializer(SslContext sslContext) {
        this.SSLContext = sslContext;
    }

    @Override
    public void initChannel(SocketChannel channel){
        ChannelPipeline pipeline = channel.pipeline();
        if(SSLContext !=null){
            pipeline.addLast(SSLContext.newHandler(channel.alloc()));
        }
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(64*1024));
        pipeline.addLast(new ClientSubscriptionHandler());
        pipeline.addLast(new WebSocketServerCompressionHandler());
        pipeline.addLast(new WebSocketServerProtocolHandler(WEBSOCKET_PATH, null, true));
        pipeline.addLast(new ClientSubscriptionFrameHandler());


    }
}
