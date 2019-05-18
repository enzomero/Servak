package com.jonny.viewapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.jonny")
//@EnableJpaRepositories("com.jonny")
//@EntityScan("com.jonny")
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ViewApplication
//Starts View part of viewapp
{
    public static void main(String[] args) {SpringApplication.run(ViewApplication.class, args);}
}


