package com.vcs.toptags.page_adapters;


public class NewsPage extends NewsPageAbsMethods implements INewsPage {

    protected NewsPage() {
    }

    protected NewsPage(String web, String encoding, String activeTag, String hrefTag, boolean addWebPageDomain) {
        this.web = web;
        this.encoding = encoding;
        this.activeTag = activeTag;
        this.hrefTag = hrefTag;
        this.addWebPageDomain = addWebPageDomain;
    }
}