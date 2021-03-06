package lt.vianet.toptags.page_adapters;

import java.util.ArrayList;
import java.util.List;


public class NewsPageObjects {

    private List<INewsPage> newsPageList = new ArrayList<>();

    public NewsPageObjects() {
        newsPageList.add(new NewsPage("https://www.alfa.lt", "utf-8", "article-card", "\"", true));
        newsPageList.add(new NewsPage("https://www.delfi.lt/", "utf-8", "headline-image", "\"", false));
        newsPageList.add(new NewsPage("http://www.diena.lt/", "utf-8", "naujausios_list", "\'", true));
        newsPageList.add(new NewsPage("https://www.vz.lt/", "windows-1257", "\"article\"", "\"", false));
    }

    public List<INewsPage> getNewsPageObjects() {

        return newsPageList;
    }
}
