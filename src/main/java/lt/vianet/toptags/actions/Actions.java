package lt.vianet.toptags.actions;

import lt.vianet.toptags.rest_controllers.CalculationThread;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Actions {

    @PostConstruct
    public void actionsWithNewsWebPages() throws InterruptedException {

        // Visu duomenu is puslapio gavimo metodas
        CalculationThread thread = new CalculationThread();
        thread.start();
    }


}