package com.jonny.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan(basePackages = "com.jonny")
@Configuration
public class RestConfiguration {
    RestConfiguration(){
        System.out.println("Config!");
    }
}
