package quoteprovider;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.SSLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

/**
 * Manages requests to B2C2
 */

public class QuoteProviderClient  {

    public static String getURL() {
        return URL;
    }

    private static final String URL = System.getProperty("url", "ws://127.0.0.1:8080/websocket");
   // static final String URL = System.getProperty("url", "wss://socket.uat.b2c2.net/quotes");
    //static final String TOKEN = "Token 9b44b09199c61bcf9416ad846dd0e4";
    private static final String TOKEN_EMAILED = "Token e13e627c49705f83cbe7b60389ac411b6f86fee7";

    public static int getPort() {
        return port;
    }

    private static final int port = 80;
    public static SimpleChannelInboundHandler<Object> getHandler() throws UnknownHostException, SSLException, URISyntaxException {

        URI uri = new URI(URL);
        String scheme = uri.getScheme() == null? "ws" : uri.getScheme();
        final String host = uri.getHost() == null? "127.0.0.1" : uri.getHost();
        //final int port = (uri.getPort() == -1) ? getPort(scheme) : uri.getPort();
        final int port = 80;
        System.out.println(InetAddress.getByName(host));

        if (!"ws".equalsIgnoreCase(scheme) && !"wss".equalsIgnoreCase(scheme)) {
            System.err.println("Only WS(S) is supported.");
            return null;
        }

        final boolean ssl = "wss".equalsIgnoreCase(scheme);
        final SslContext sslContext = ssl ? getSSLContext(): null;

            DefaultHttpHeaders authorisedHeader = new DefaultHttpHeaders();
            authorisedHeader.add("Authorization", TOKEN_EMAILED);

            final QuoteProviderHandler handler =
                    new QuoteProviderHandler(
                            WebSocketClientHandshakerFactory.newHandshaker(
                                    uri, WebSocketVersion.V13, null, true, authorisedHeader));
            return handler;
        }

    public static void main(String[] args) throws Exception {
        URI uri = new URI(URL);
        String scheme = uri.getScheme() == null? "ws" : uri.getScheme();
        final String host = uri.getHost() == null? "127.0.0.1" : uri.getHost();
       //final int port = (uri.getPort() == -1) ? getPort(scheme) : uri.getPort();
        final int port = 80;
        System.out.println(InetAddress.getByName(host));

        if (!"ws".equalsIgnoreCase(scheme) && !"wss".equalsIgnoreCase(scheme)) {
            System.err.println("Only WS(S) is supported.");
            return;
        }

        final boolean ssl = "wss".equalsIgnoreCase(scheme);

        EventLoopGroup group = new NioEventLoopGroup();
        try {

            DefaultHttpHeaders authorisedHeader = new DefaultHttpHeaders();
            authorisedHeader.add("Authorization", TOKEN_EMAILED);

            final QuoteProviderHandler handler =
                    new QuoteProviderHandler(
                            WebSocketClientHandshakerFactory.newHandshaker(
                                    uri, WebSocketVersion.V13, null, true, authorisedHeader));

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class);
             //       .handler();

           // ChannelFuture future = bootstrap.connect(uri.getHost(), port).sync();
            //Channel channel = future.channel();
            Channel channel = bootstrap.bind(80).sync().channel();
            handler.handshakeFuture().sync();
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            //Replace with lookup instrument: client mapping

            while (true) {
                String msg = console.readLine();
                WebSocketFrame frame = new TextWebSocketFrame(msg);
                channel.writeAndFlush(frame);
                }

        }

        finally {
            group.shutdownGracefully();
        }
    }

    private static SslContext getSSLContext() throws SSLException {
        return SslContextBuilder.forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
    }

    private static int getPort(String scheme) {
        return ("ws".equalsIgnoreCase(scheme)) ? 80 : ("wss".equalsIgnoreCase(scheme)) ? 443 : -1;
    }
}
