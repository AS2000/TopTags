package lt.vianet.toptags.db;

import lt.vianet.toptags.page_adapters.INewsPage;
import lt.vianet.toptags.rest_controllers.CalculationThread;

import java.util.List;


public class WordsDB implements IWordsDB {

    private List<INewsPage> lastTopWords;

    @Override
    public List<INewsPage> getWordsDB() {
        synchronized (CalculationThread.LAST_TOP_WORDS) {
            return lastTopWords;
        }
    }

    @Override
    public void setWordsDB(List<INewsPage> lastTopWords) {
        synchronized (CalculationThread.LAST_TOP_WORDS) {
            this.lastTopWords = lastTopWords;
        }
    }
}
