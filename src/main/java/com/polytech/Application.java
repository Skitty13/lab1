package com.polytech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Polytech Marseille
 * Created by Lucile Texier on 07/04/2017.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "DEV");
        SpringApplication.run(Application.class, args);
    }
}
