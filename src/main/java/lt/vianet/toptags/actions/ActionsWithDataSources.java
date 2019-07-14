package lt.vianet.toptags.actions;

import lt.vianet.toptags.cleaning_process.ActiveLinksFromJS;
import lt.vianet.toptags.cleaning_process.CleanAndCalculate;
import lt.vianet.toptags.utils.TopWordsQty;
import lt.vianet.toptags.page_adapters.INewsPage;
import lt.vianet.toptags.page_adapters.NewsPageObjects;

import java.util.List;


public class ActionsWithDataSources {

    public List<INewsPage> actionsWithNewsWebPages() {
        int qtyTopWords = getQtyTopWords();

        List<INewsPage> newsPageList = generateNewsPageObjects();

        //Get Active (JavaScript) links of pages with text
        for (int i = 0; i < newsPageList.size(); i++) {

            // get from the Page Java Script Dynamic links and Set it To Page Object
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