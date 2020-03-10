package lt.vianet.toptags.rest_controllers;

import lt.vianet.toptags.actions.ActionsWithDataSources;
import lt.vianet.toptags.db.IWordsDB;
import lt.vianet.toptags.db.WordsDB;
import lt.vianet.toptags.utils.CheckTime;
import lt.vianet.toptags.utils.RereadDelay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Calculation {

    private static final Logger LOG = LoggerFactory.getLogger(Calculation.class);

    public static IWordsDB LAST_TOP_WORDS = new WordsDB();
    public static String SCAN_TIME;
    private int timeOutMin = getTimeOutMin();

    // Visu duomenu is puslapio gavimo metodas
    @Scheduled(fixedRate = 900000)
    private void getNewData() {
        System.out.println("15 min");
        LAST_TOP_WORDS.setWordsDB((new ActionsWithDataSources()).actionsWithNewsWebPages());
    }
//                LOG.error(ie.getMessage(), ie);


    // Get Timeout Minutes of Listed Words form /src/main/resources
    private int getTimeOutMin() {
        return (new RereadDelay()).getTimeOutMin();
    }
}
