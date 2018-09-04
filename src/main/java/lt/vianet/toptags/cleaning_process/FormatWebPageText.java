package lt.vianet.toptags.cleaning_process;

import java.util.List;

public class FormatWebPageText {

    List<StringBuffer> htmlFromWebArray;

    public FormatWebPageText(List<StringBuffer> htmlFromWebArray) {
        this.htmlFromWebArray = htmlFromWebArray;
    }


    public List<String> getFormatedWords() {

        return grabAndFormatWordsFromWebPage();
    }


    private List<String> grabAndFormatWordsFromWebPage() {

        //Get text Array clean from tags and etc.
        CleanTheText ctt = new CleanTheText();
        List<String> allWordsArray = ctt.getCleanTextArray(htmlFromWebArray);

        // clean useless words
        allWordsArray = cleanUselessWords(allWordsArray);

        return allWordsArray;
    }


    private List<String> cleanUselessWords(List<String> array) {
        CleanUselesWords cuw = new CleanUselesWords();
        return cuw.getClean(array);
    }
}
