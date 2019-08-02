package com.experis.reto.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan("com.experis.reto")
public class RetoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetoApplication.class, args);
    }

}
