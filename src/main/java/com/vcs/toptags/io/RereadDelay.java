package com.vcs.toptags.io;

import java.io.*;
import java.util.Properties;

public class RereadDelay {
    public int getTimeOutMin() {
        try {
            Properties prop = new Properties();
            prop.load(getClass().getClassLoader().getResourceAsStream("application.properties"));

            return Integer.valueOf(prop.getProperty("timeOutMin", "15"));

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return 15;
    }
}
