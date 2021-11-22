package util;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.SSLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.security.cert.CertificateException;

/**
 * Util functions here
 * */




public class Util {
    private final String URI = "https://api.uat.b2c2.net/currency/";

    public static String getSSL(){
        return System.getProperty("ssl");
    }
    /**
     * Gets list of instruments that B2C2 has price for, so we only accept the same from our client.
     * */
//    public static void main(String[] args) {
//        HttpRequestHandler handler = new HttpRequestHandler();
//        handler.getB2C2Instruments();
//    }



    public static SslContext getSSLContext() {
        SslContext sslContext = null;
        try {

            if (getSSL() != null) {
                SelfSignedCertificate selfSignedCertificate = new SelfSignedCertificate();
                sslContext = SslContextBuilder.
                        forServer(selfSignedCertificate.certificate(), selfSignedCertificate.privateKey())
                        .build();
            } else {
                sslContext = null;
            }
        }catch(CertificateException |SSLException e) {
            e.printStackTrace();
        }
        return sslContext;
    }

    public StringBuffer getB2C2Instruments(){

        StringBuffer instrument = null;
        try {
            URL url = new URL("https://api.uat.b2c2.net/currency/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            instrument = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                instrument.append(inputLine);
            }
            in.close();
            connection.disconnect();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return instrument;
    }

}
