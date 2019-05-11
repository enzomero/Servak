package com.jonny.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.jonny")
@EnableJpaRepositories("com.jonny")
@EntityScan("com.jonny")
@SpringBootApplication
public class RestApplication{
    public static void main(String[] args) { SpringApplication.run(RestApplication.class, args); }
}