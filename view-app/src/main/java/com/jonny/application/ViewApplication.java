package com.jonny.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.jonny")
//@EnableJpaRepositories("com.jonny")
//@EntityScan("com.jonny")
@SpringBootApplication
public class ViewApplication
//Starts View part of application
{
    public static void main(String[] args) {SpringApplication.run(ViewApplication.class, args);}
}


