package quoteprovider;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketFrameAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;
import util.Util;

import java.net.URI;
import java.net.URISyntaxException;

public class QuoteProviderInitializer extends ChannelInitializer<SocketChannel>{


    private static final String URL = System.getProperty("url", "ws://127.0.0.1:8080/websocket");
    // static final String URL = System.getProperty("url", "wss://socket.uat.b2c2.net/quotes");
    //URI uri = new URI(URL);

    //final int port = (uri.getPort() == -1) ? getPort(scheme) : uri.getPort();
    final int port = 80;
    //static final String TOKEN = "Token 9b44b09199c61bcf9416ad846dd0e4";
    private static final String TOKEN_EMAILED = "Token e13e627c49705f83cbe7b60389ac411b6f86fee7";


    @Override
        protected void initChannel(SocketChannel channel) throws URISyntaxException {

        URI uri = new URI(URL);
        String scheme = uri.getScheme() == null? "ws" : uri.getScheme();
        final String host = uri.getHost() == null? "127.0.0.1" : uri.getHost();
            ChannelPipeline pipeline = channel.pipeline();
            if (Util.getSSLContext() != null) {
                pipeline.addLast(Util.getSSLContext().newHandler(channel.alloc(), host, port));
            }

        DefaultHttpHeaders authorisedHeader = new DefaultHttpHeaders();
        authorisedHeader.add("Authorization", TOKEN_EMAILED);
            pipeline.addLast(new HttpClientCodec());
        pipeline.addLast(new HttpObjectAggregator(8192));
        pipeline.addLast(new WebSocketFrameAggregator(8192));
        pipeline.addLast(WebSocketClientCompressionHandler.INSTANCE);
        pipeline.addLast(new QuoteProviderHandler(                            WebSocketClientHandshakerFactory.newHandshaker(
                uri, WebSocketVersion.V13, null, true, authorisedHeader)));
        }
    }
