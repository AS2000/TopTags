package lt.vianet.toptags.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TopWordsQty {
    public int getQtyTopWords() {
        try {
            Properties prop = new Properties();
            prop.load(getClass().getClassLoader().getResourceAsStream("application.properties"));

            return Integer.valueOf(prop.getProperty("qtyTopWords", "5"));

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return 5;
    }
}
