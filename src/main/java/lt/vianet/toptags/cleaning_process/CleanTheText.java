package lt.vianet.toptags.cleaning_process;

import java.util.ArrayList;
import java.util.List;

public class CleanTheText {


    public List<String> getCleanTextArray(List<StringBuffer> htmlFromWebArray) {

        // Change HTML Array to the LowerCase: StringBuffer => String => StringBuffer
        htmlFromWebArray = convertToLowerCase(htmlFromWebArray);

        // Method, that replaces TABs in the String HTML to the Spaces to avoid collisions
        htmlFromWebArray = replaceTabsWithSpaces(htmlFromWebArray);

        // Method, that replaces <style> ... </style> Tags in the String HTML to the Spaces to avoid collisions
        htmlFromWebArray = replaceStyleTagsWithSpaces(htmlFromWebArray);

        // Method, that replaces <script> Tags in the String HTML to the Spaces to avoid collisions
        htmlFromWebArray = replaceScriptTagsWithSpaces(htmlFromWebArray);

        // Method, that replaces All Tags ( from < to >) Tags in the String HTML to the Spaces to avoid collisions
        htmlFromWebArray = replaceAllTagsWithSpaces(htmlFromWebArray);

        // Method, that replaces All special ( starts with "&"  to " ;", till the 7 char long) Tags in the String HTML to the Spaces to avoid collisions
        htmlFromWebArray = replaceSpecialTagsWithSpaces(htmlFromWebArray);

        // grab the text with Regex and move to ArrayList and MERGE them to one
        return grabTextWithRegex(htmlFromWebArray);
    }


    private List<StringBuffer> convertToLowerCase(List<StringBuffer> htmlFromWebArray) {

        String toLowerCase;

        List<StringBuffer> stringToStringbufferArray = new ArrayList<>();

        for (int i = 0; i < htmlFromWebArray.size(); i++) {
            toLowerCase = htmlFromWebArray.get(i).toString().toLowerCase();
            stringToStringbufferArray.add(new StringBuffer(toLowerCase.subSequence(0, toLowerCase.length())));
        }
        return stringToStringbufferArray;
    }

    private List<StringBuffer> replaceTabsWithSpaces(List<StringBuffer> htmlFromWebArray) {

        // remove Tabs
        String withoutTabs;

        List<StringBuffer> removedTABsArray = new ArrayList<>();

        for (int i = 0; i < htmlFromWebArray.size(); i++) {
            withoutTabs = htmlFromWebArray.get(i).toString().toLowerCase().replaceAll("\u0009", " ");
            removedTABsArray.add(new StringBuffer(withoutTabs.subSequence(0, withoutTabs.length())));
        }
        return removedTABsArray;
    }

    private List<StringBuffer> replaceStyleTagsWithSpaces(List<StringBuffer> htmlFromWebArray) {
        StyleTagRemover str = new StyleTagRemover();
        List<StringBuffer> removedStyleTagsArray = new ArrayList<>();

        // remove Style Tags
        for (int i = 0; i < htmlFromWebArray.size(); i++) {
            removedStyleTagsArray.add(str.getCleanText(htmlFromWebArray.get(i)));
        }
        return removedStyleTagsArray;
    }

    private List<StringBuffer> replaceScriptTagsWithSpaces(List<StringBuffer> htmlFromWebArray) {

        ScriptTagRemover str = new ScriptTagRemover();
        List<StringBuffer> removedScriptTagsArray = new ArrayList<>();

        for (int i = 0; i < htmlFromWebArray.size(); i++) {
            removedScriptTagsArray.add(str.getCleanText(htmlFromWebArray.get(i)));
        }
        return removedScriptTagsArray;
    }

    private List<StringBuffer> replaceAllTagsWithSpaces(List<StringBuffer> htmlFromWebArray) {

        // remove All Tags from "<"  till ">"
        AllTagRemover atr = new AllTagRemover();
        List<StringBuffer> removedAllTagsArray = new ArrayList<>();

        for (int i = 0; i < htmlFromWebArray.size(); i++) {
            removedAllTagsArray.add(atr.getCleanText(htmlFromWebArray.get(i)));
        }
        return removedAllTagsArray;
    }

    private List<StringBuffer> replaceSpecialTagsWithSpaces(List<StringBuffer> htmlFromWebArray) {

        // remove All Special Tags ( starts with "&"  to " ;", till the 7 char long)
        SpecialSimbolRemover ssr = new SpecialSimbolRemover();
        List<StringBuffer> removedSpecialTagsArray = new ArrayList<>();

        for (int i = 0; i < htmlFromWebArray.size(); i++) {
            removedSpecialTagsArray.add(ssr.getCleanText(htmlFromWebArray.get(i)));
        }
        return removedSpecialTagsArray;
    }

    private List<String> grabTextWithRegex(List<StringBuffer> htmlFromWebArray) {

        // grab the text with Regex and move to ArrayList and MERGE them to one
        GrabTextWithRegex gttwr = new GrabTextWithRegex();
        List<String> cleanTextArray = new ArrayList<>();

        for (int i = 0; i < htmlFromWebArray.size(); i++) {
            cleanTextArray.addAll(gttwr.getThePureText(htmlFromWebArray.get(i)));
        }
        return cleanTextArray;
    }


}
