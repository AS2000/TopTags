package com.vcs.toptags.actions;

import com.vcs.toptags.db.IWordsDB;
import com.vcs.toptags.db.WordsDB;
import com.vcs.toptags.rest_controllers.CalculationThread;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Actions {

    public static IWordsDB LAST_TOP_WORDS = new WordsDB();

    @PostConstruct
    public void actionsWithNewsWebPages() throws InterruptedException {

        // Visu duomenu is puslapio gavimo metodas
        CalculationThread thread = new CalculationThread();
        thread.start();
    }


}