package util;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.SSLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.cert.CertificateException;

public class Util {

    private static final boolean SSL = System.getProperty("ssl") != null;
   // private static String REMOTE_URL = System.getProperty("url", "ws://127.0.0.1:443/websocket");
  //  private static final String REMOTE_URL = System.getProperty("url", "http://www.iptc.org/std/catalog/catalog.IPTC-G2-Standards_3.xml");
    //private static final String REMOTE_URL = System.getProperty("url", "www.google.com");
  static final String REMOTE_URL = System.getProperty("url", "ws://127.0.0.1:8080/websocket");
    // private static final String URL = System.getProperty("url", "wss://socket.uat.b2c2.net/quotes");
  //static final int REMOTE_PORT = Integer.parseInt(System.getProperty("remotePort", "443"));
  private static final int LOCAL_PORT = Integer.parseInt(System.getProperty("localPort", "8443"));
    // static final String REMOTE_HOST = System.getProperty("remoteHost", "www.google.com");
    //static final String TOKEN = "Token 9b44b09199c61bcf9416ad846dd0e4";
    final static String TOKEN_EMAILED = "Token e13e627c49705f83cbe7b60389ac411b6f86fee7";
    private static final String WEBSOCKET_PATH = "/websocket";



    SelfSignedCertificate selfSignedCertificate = null;

    public static final SslContext serverSSLContext() {

        SslContext sslContext = null;
        SelfSignedCertificate selfSignedCertificate = null;

        try {

            if (SSL) {
                selfSignedCertificate = new SelfSignedCertificate();
                sslContext = SslContextBuilder.
                        forServer(selfSignedCertificate.certificate(), selfSignedCertificate.privateKey())
                        .build();
            } else {
                sslContext = null;
            }
        } catch (SSLException | CertificateException e) {
            e.printStackTrace();
        }
        return sslContext;

    }

    private static SslContext clientSSLContext() throws SSLException {
        return SslContextBuilder.forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
    }

    public static URI getRemoteURI() {

        URI uri = null;
        try {
            uri = new URI(REMOTE_URL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }

    public static String getToken() {
        return TOKEN_EMAILED;
    }

    public static String getWebSocketPath() {
        return WEBSOCKET_PATH;
    }

    public static int getLocalPort(){
        return LOCAL_PORT;
    }
}
