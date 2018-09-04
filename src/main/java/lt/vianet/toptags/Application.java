package lt.vianet.toptags;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"lt.vianet.toptags.*"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}