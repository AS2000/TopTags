package com.vcs.toptags.actions;

import com.vcs.toptags.cleaning_process.ActiveLinksFromJS;
import com.vcs.toptags.cleaning_process.CleanAndCalculate;
import com.vcs.toptags.io.TopWordsQty;
import com.vcs.toptags.page_adapters.INewsPage;
import com.vcs.toptags.page_adapters.NewsPageObjects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class ActionsWithDataSources {

//    @Value("${qtyTopWords}")
//    private int qtyTopWords;



    public List<INewsPage> actionsWithNewsWebPages() {
        int qtyTopWords = getQtyTopWords();

        List<INewsPage> newsPageList = generateNewsPageObjects();

        //Get Active (JavaScript) links of pages with text
        for (int i = 0; i < newsPageList.size(); i++) {

            // get active links from the Page Java Script Dynamic links and Set it To Page Object
            setJSLinksFromWebPageToObject(newsPageList.get(i));

            // filteredTopWordsArray [] moved to the Object value
            new CleanAndCalculate(newsPageList.get(i), qtyTopWords).actionsWithNewsWebPages();
        }

        // adding dynamic scanned words to the static array for the upload

        return newsPageList;
    }

    // Get Quantity of Listed Words form /src/main/resources

    private int getQtyTopWords() {

        return (new TopWordsQty()).getQtyTopWords();
    }

    // Get News Pages Object Array
    private List<INewsPage> generateNewsPageObjects() {
        NewsPageObjects npo = new NewsPageObjects();

        return npo.getNewsPageObjects();
    }

    // get active links from thePage Java Script Dynamic links nad Set it To Page Object
    private void setJSLinksFromWebPageToObject(INewsPage newsPage) {

        newsPage.setActiveLinks(new ActiveLinksFromJS().getActiveLinksFromJavaScript(newsPage));
    }

}