package com.vcs.toptags.rest_controllers;

import com.vcs.toptags.actions.ActionsWithDataSources;
import com.vcs.toptags.db.IWordsDB;
import com.vcs.toptags.db.WordsDB;
import com.vcs.toptags.io.RereadDelay;
import org.springframework.stereotype.Component;


@Component
public class CalculationThread extends Thread {
    public static IWordsDB LAST_TOP_WORDS = new WordsDB();
    private int timeOutMin = getTimeOutMin();

    @Override
    public void run() {
        while (true) {

            getNewData();

            try {

                Thread.sleep(timeOutMin * 60000);

            } catch (InterruptedException e) {
                e.printStackTrace();
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
