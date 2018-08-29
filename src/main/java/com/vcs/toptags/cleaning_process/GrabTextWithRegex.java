package com.vcs.toptags.cleaning_process;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GrabTextWithRegex {
    public List<String> getThePureText(StringBuffer buffer) {
        return cleanText(buffer);
    }


    private List<String> cleanText(StringBuffer buffer) {

        List<String> pureTextList = new ArrayList();

        //https://docs.oracle.com/javase/1.5.0/docs/api/java/util/regex/Pattern.html
        Pattern pattern = Pattern.compile("([\\p{L}&&[^\\p{Lu}]]{3,}+)", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = pattern.matcher(buffer.toString());

        while (m.find()) {
            pureTextList.add(m.group());
        }
        return pureTextList;
    }

}
