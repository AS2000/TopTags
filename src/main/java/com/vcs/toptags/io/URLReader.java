package com.vcs.toptags.io;

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

// Buvo: BufferedReader reader = new BufferedReader(new InputStreamReader(web.openStream()));
//
// InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "windows-1251");
// BufferedReader br = new BufferedReader(isr);
//
// String utf8String= new String(res.getBytes("UTF-8"), "windows-1251");
// Вы фактически переводите UTF-8 в windows-1251, а отображаете как UTF-8.
//

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
