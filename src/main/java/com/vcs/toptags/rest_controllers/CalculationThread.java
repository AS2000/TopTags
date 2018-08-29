package com.vcs.toptags.rest_controllers;

import com.vcs.toptags.actions.ActionsWithDataSources;
import com.vcs.toptags.io.RereadDelay;
import org.springframework.stereotype.Component;

import static com.vcs.toptags.actions.Actions.LAST_TOP_WORDS;

@Component
public class CalculationThread extends Thread {
    private int timeOutMin = getTimeOutMin();

    @Override
    public void run() {
        while (true) {
            getNewData();

            try {
                Thread.sleep(timeOutMin * 60000);
                //           TimeUnit.MINUTES.sleep(timeOutMin);
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
