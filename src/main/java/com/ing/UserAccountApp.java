package com.ing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ing"})
public class UserAccountApp {

    public static void main(String[] args) {
        SpringApplication.run(UserAccountApp.class, args);
    }

}
