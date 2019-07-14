package lt.vianet.toptags.utils;

import java.util.ArrayList;
import java.util.List;

public class HtmlFromActiveLinks {

    public List<StringBuffer> getHTMLArray(List<String> activeLinks, String encoding) {

        return grabHTMLinkPlainText(activeLinks, encoding);
    }

    private List<StringBuffer> grabHTMLinkPlainText(List<String> activeLinks, String encoding) {
        List<StringBuffer> htmlArray = new ArrayList<>();

        URLReader url = new URLReader();

        for (int i = 0; i < activeLinks.size(); i++) {
            htmlArray.add(url.getPlainText(activeLinks.get(i), encoding));

        }

        return htmlArray;
    }

}
