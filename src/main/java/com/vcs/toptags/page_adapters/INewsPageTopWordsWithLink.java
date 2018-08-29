package com.vcs.toptags.page_adapters;


public interface INewsPageTopWordsWithLink extends INewsPageTopWords {

    public String getWebDomain();

    public Integer getCheckedWordsQty();

    public Integer getUniqueWordsQty();
}
