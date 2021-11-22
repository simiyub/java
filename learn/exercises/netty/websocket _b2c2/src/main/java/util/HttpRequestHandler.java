package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Util functions here
 * */
public class HttpRequestHandler{
    private final String URI = "https://api.uat.b2c2.net/currency/";


    /**
     * Gets list of instruments that B2C2 has price for, so we only accept the same from our client.
     * */
    public static void main(String[] args) {
        HttpRequestHandler handler = new HttpRequestHandler();
        handler.getB2C2Instruments();
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
