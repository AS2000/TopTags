package com.vcs.toptags.io;

import java.io.*;
import java.util.Properties;

public class RereadDelay {
    public int getTimeOutMin() {
        try {
            File f = new File("config.properties");
            InputStream inStream = new FileInputStream(f);
            Properties prop = new Properties();
            prop.load(inStream);

            return Integer.valueOf(prop.getProperty("timeOutMin", "15"));

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return 15;
    }
}
