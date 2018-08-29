package com.vcs.toptags.io;

import java.io.*;
import java.util.Properties;

public class TopWordsQty {
    public int getQtyTopWords() {
        try {
            File f = new File("config.properties");
            InputStream inStream = new FileInputStream(f);
            Properties prop = new Properties();
            prop.load(inStream);

            return Integer.valueOf(prop.getProperty("qtyTopWords", "5"));

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return 5;
    }
}
