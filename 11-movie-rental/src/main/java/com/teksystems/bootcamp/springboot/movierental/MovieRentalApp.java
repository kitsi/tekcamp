package com.teksystems.bootcamp.springboot.movierental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRentalApp {

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalApp.class, args);
        System.out.println("server side wired up!");
    }

}
