package com.vcs.toptags.cleaning_process;

import com.vcs.toptags.io.OpenUselesWordFile;

import java.util.List;


public class CleanUselesWords {

    public List<String> getClean(List<String> inArray) {

        return cleanText(inArray);
    }

    private List<String> cleanText(List<String> inArray) {
        OpenUselesWordFile ouwf = new OpenUselesWordFile();
        List<String> uselessWords = ouwf.getUselesWordsList();

        for (int i = 0; i < uselessWords.size(); i++) {
            for (int j = (inArray.size() - 1); j >= 0; j--) {

                if (uselessWords.get(i).equals(inArray.get(j))) {
                    inArray.remove(j);
                }
            }
        }
        return inArray;
    }
}