package com.wyc.hm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HmApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmApplication.class, args);
        System.out.println("\nSpringboot have been started!");
    }

}
