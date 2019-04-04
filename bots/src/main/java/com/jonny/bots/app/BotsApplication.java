package com.jonny.bots.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.telegram.telegrambots.ApiContextInitializer;

@ComponentScan(basePackages = "com.jonny.bots")
@SpringBootApplication
public class BotsApplication {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(BotsApplication.class, args);
    }
}
