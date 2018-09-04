package lt.vianet.toptags.page_adapters;

public class NewsPageTopWords implements INewsPageTopWords {

    // Filterred Top Words Array
    private String[] filteredTopWordsArray;

    public NewsPageTopWords() {
    }

    public NewsPageTopWords(String[] filteredTopWordsArray) {

            this.filteredTopWordsArray = filteredTopWordsArray;
    }

    @Override
    public String[] getFilteredTopWordsArray() {

        synchronized (filteredTopWordsArray) {
            return filteredTopWordsArray;
        }
    }

}
