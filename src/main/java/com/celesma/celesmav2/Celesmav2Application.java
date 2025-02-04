package com.celesma.celesmav2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Celesmav2Application {

    public static void main(String[] args) {
        SpringApplication.run(Celesmav2Application.class, args);
    }

}
