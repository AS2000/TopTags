package com.vcs.toptags;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan({"com.vcs.toptags.*"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}