package lt.vianet.toptags.db;

import lt.vianet.toptags.page_adapters.INewsPage;

import java.util.List;

public interface IWordsDB {
    public List<INewsPage> getWordsDB();

    public void setWordsDB(List<INewsPage> lastTopWords);
}
