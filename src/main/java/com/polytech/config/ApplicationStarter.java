package com.polytech.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Polytech Marseille
 * Created by Lucile Texier on 16/03/2017.
 */

@SpringBootApplication
public class ApplicationStarter {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","DEV");
       SpringApplication.run(ApplicationStarter.class, args);

    }

}
