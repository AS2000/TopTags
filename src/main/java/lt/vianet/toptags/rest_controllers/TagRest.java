package lt.vianet.toptags.rest_controllers;

import lt.vianet.toptags.page_adapters.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class TagRest {

    @Autowired
    private HTMLService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHTML() {
        return service.getHTML(getPageObjectWithWebAndQty());
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public List<INewsPageTopWordsWithLink> getJSON() {
        return getPageObjectWithWebAndQty();
    }

    @RequestMapping(value = "/json/{web}", method = RequestMethod.GET)
    public INewsPageTopWords getPage(@PathVariable("web") String web) {

        for (INewsPage page : Calculation.LAST_TOP_WORDS.getWordsDB()) {
            if (page.getWebDomain().contains(web)) {
                return new NewsPageTopWords(page.getFilteredTopWordsArray());
            }
        }
        return new NewsPageTopWords();
    }

    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    public String wrongText(@PathVariable("text") String textFromRequest) {
        return "<!DOCTYPE html><html><body><h1>Neteisingas pletinys</h1><br><p>tokio pletinio nera:<b> " + textFromRequest +
                "</p>Naudok: <b>/</b>  arba  <b>/json</b></body></html>";
    }


    private List<INewsPageTopWordsWithLink> getPageObjectWithWebAndQty() {
        List<INewsPageTopWordsWithLink> pageList = new ArrayList<>();
        for (INewsPage page : Calculation.LAST_TOP_WORDS.getWordsDB()) {
            pageList.add(new NewsPageTopWordsWithLink(page.getWebDomain(), page.getFilteredTopWordsArray(), page.getCheckedWordsQty(), page.getUniqueWordsQty()));
        }
        return pageList;
    }
}
