package com.vcs.toptags.db;

import com.vcs.toptags.page_adapters.INewsPage;

import java.util.List;

public interface IWordsDB {
    public List<INewsPage> getWordsDB();

    public void setWordsDB(List<INewsPage> lastTopWords);
}
