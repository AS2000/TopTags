package lt.vianet.toptags.page_adapters;

import java.util.List;


public abstract class NewsPageAbsMethods implements INewsPage {
    protected String web;
    protected String encoding;
    protected String activeTag;
    protected String hrefTag;
    // Internal Page links taked from Dynamic JavaScript Array
    protected List<String> activeLinks;
    // Filterred Top Words Array
    protected String[] filteredTopWordsArray;
    // if true: add www.alfa.lt to the dynamic link
    protected boolean addWebPageDomain;
    // Quantity of the Checked words grabbed from the page
    protected Integer checkedWordsQty = 0;
    // Quantity of the Unique words grabbed from the page
    protected Integer uniqueWordsQty = 0;


    @Override
    public String getWebDomain() {

        return web;
    }

    @Override
    public String getEncoding() {

        return encoding;
    }

    @Override
    public String getActiveTag() {
        return activeTag;
    }

    @Override
    public String getHrefTag() {
        return hrefTag;
    }

    @Override
    public List<String> getActiveLinks() {

        return activeLinks;
    }

    @Override
    public void setActiveLinks(List<String> activeLinks) {

        this.activeLinks = activeLinks;
    }

    @Override
    public boolean isAddWebPageDomain() {
        return addWebPageDomain;
    }

    @Override
    public String[] getFilteredTopWordsArray() {
        return filteredTopWordsArray;
    }

    @Override
    public void setFilteredTopWordsArray(String[] filteredTopWordsArray) {
        this.filteredTopWordsArray = filteredTopWordsArray;
    }

    @Override
    public Integer getCheckedWordsQty() {
        return checkedWordsQty;
    }

    @Override
    public void setCheckedWordsQty(Integer checkedWordsQty) {
        this.checkedWordsQty = checkedWordsQty;
    }

    @Override
    public Integer getUniqueWordsQty() {
        return uniqueWordsQty;
    }

    @Override
    public void setUniqueWordsQty(Integer uniqueWordsQty) {
        this.uniqueWordsQty = uniqueWordsQty;
    }
}