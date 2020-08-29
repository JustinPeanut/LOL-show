package com.peanut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.peanut.api")
public class HeroMain {
    public static void main(String[] args) {
        SpringApplication.run(HeroMain.class,args);
    }
}
