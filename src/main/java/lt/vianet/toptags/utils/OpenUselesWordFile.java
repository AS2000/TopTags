package lt.vianet.toptags.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OpenUselesWordFile {

    public List<String> getUselesWordsList() {

        return loadList();
    }

    // --------- Duomenu ATKURIMAS ---------

    private List<String> loadList() {

        String FILE_NAME = "";

        try {
            File jarFile = new File("");
            FILE_NAME +="" + jarFile.getAbsolutePath() + File.separator + "uselesswords.txt";
            File file = new File(FILE_NAME);

            // Patikrinimas ar failas egzistuoja
            if (file.exists()) {

            } else {
                // jei failas neegzituoja, tai yra sukuriamas, kad nekiltu klaidos
                file.createNewFile();
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        // Atkuriame duomenys is failo
        List loadArray = new ArrayList<String>();

        try {
            FileInputStream is = new FileInputStream(FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "Unicode"));

            // Perkeliam visus irasus i ArrayList
            String readline;
            while ((readline = reader.readLine()) != null) {
                loadArray.add(readline);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        return loadArray;
    }
}

