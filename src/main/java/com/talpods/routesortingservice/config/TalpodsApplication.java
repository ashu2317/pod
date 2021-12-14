package com.talpods.routesortingservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.talpods.routesortingservice"})
public class TalpodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalpodsApplication.class, args);
    }

}
