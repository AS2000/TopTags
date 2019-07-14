package lt.vianet.toptags.rest_controllers;

import lt.vianet.toptags.actions.ActionsWithDataSources;
import lt.vianet.toptags.db.IWordsDB;
import lt.vianet.toptags.db.WordsDB;
import lt.vianet.toptags.utils.CheckTime;
import lt.vianet.toptags.utils.RereadDelay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CalculationThread extends Thread {

    private static final Logger LOG = LoggerFactory.getLogger(CalculationThread.class);

    public static IWordsDB LAST_TOP_WORDS = new WordsDB();
    public static String SCAN_TIME;
    private int timeOutMin = getTimeOutMin();

    @Override
    @Scope("prototype")
    public void run() {
        while (true) {

            getNewData();
            SCAN_TIME = new CheckTime().getTime();
            try {
                Thread.sleep(timeOutMin * 60000);
            } catch (InterruptedException ie) {
                LOG.error(ie.getMessage(), ie);
            }
        }
    }

    private void getNewData() {
        LAST_TOP_WORDS.setWordsDB((new ActionsWithDataSources()).actionsWithNewsWebPages());
    }

    // Get Timeout Minutes of Listed Words form /src/main/resources
    private int getTimeOutMin() {
        return (new RereadDelay()).getTimeOutMin();
    }
}
