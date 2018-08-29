package com.vcs.toptags.cleaning_process;

import com.vcs.toptags.io.URLReader;
import com.vcs.toptags.page_adapters.INewsPage;

import java.util.ArrayList;
import java.util.List;

public class ActiveLinksFromJS {

    public List<String> getActiveLinksFromJavaScript(INewsPage newsPage) {
        // Get Plain Text from the Web Page
        StringBuffer bufferedWebPage = grabPlainTextFromWeb(newsPage.getWebDomain(), newsPage.getEncoding());

        // Change HTML to the LowerCase: StringBuffer => String => StringBuffer
        bufferedWebPage = convertToLowerCase(bufferedWebPage);

        // Clean Active Links and move it to ArrayList
        // Returns ArrayList with Web Page Links
        return cleanDynamicTextLinksFromJS(bufferedWebPage, newsPage.getActiveTag(), newsPage.getWebDomain(), newsPage.isAddWebPageDomain(), newsPage.getHrefTag());
    }


    private StringBuffer grabPlainTextFromWeb(String web, String encoding) {
        URLReader url = new URLReader();

        return url.getPlainText(web, encoding);
    }

    private StringBuffer convertToLowerCase(StringBuffer bufferedWebPage) {
        String toLowerCase = bufferedWebPage.toString().toLowerCase();
        return new StringBuffer(toLowerCase.subSequence(0, toLowerCase.length()));
    }

    private List<String> cleanDynamicTextLinksFromJS(StringBuffer bufferedWebPage, String textDivTag, String web, boolean addWebPageDomain, String hrefTag) {

        List<String> textLinksArray = new ArrayList<>();

        try {
            // Start of search in String
            int startDiv = 0;
            int startHref, endHref, endHrefSpace, endHrefArrow;
            String linkToPage;


            while (startDiv >= 0) {

                startDiv = bufferedWebPage.indexOf(textDivTag, startDiv);
                startHref = bufferedWebPage.indexOf("a href=" + hrefTag, startDiv);
                endHrefSpace = bufferedWebPage.indexOf(hrefTag + " ", startHref);
                endHrefArrow = bufferedWebPage.indexOf(hrefTag + ">", startHref);

                // Checking for the right finish point of href Link
                if (endHrefSpace > endHrefArrow) {
                    endHref = endHrefArrow;
                } else {
                    endHref = endHrefSpace;
                }


                if ((startDiv > 0) && (startDiv < bufferedWebPage.length() && (endHref < bufferedWebPage.length()) && (startHref > 0) && (endHref > 0))) {

                    if (addWebPageDomain == true) {
                        linkToPage = web + bufferedWebPage.substring(startHref + 8, endHref);

                    } else {
                        linkToPage = bufferedWebPage.substring(startHref + 8, endHref);
                    }

                    // Add Links to Array
                    textLinksArray.add(linkToPage);
                    startDiv++;
                }
            }

        } catch (StringIndexOutOfBoundsException siobe) {
            System.out.println("You catched: " + siobe.getMessage());
        }

        return textLinksArray;
    }
}
