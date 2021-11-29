package com.swe.lawnwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Application is initiated in the main method.
 */
@SpringBootApplication // (exclude = {DataSourceAutoConfiguration.class })
public class LawnWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(LawnWebappApplication.class, args);
    }

}
