package lt.vianet.toptags.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLReader {

    public StringBuffer getPlainText(String url, String encoding) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL web = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(web.openStream(), encoding));

            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                buffer.append(inputLine + " ");
            }
            reader.close();

        } catch (MalformedURLException mue) {
            System.out.println("You catched: MalformedURLException");
        } catch (IOException ioe) {
            System.out.println("You catched: IOException");
        }
        return buffer;
    }
}
