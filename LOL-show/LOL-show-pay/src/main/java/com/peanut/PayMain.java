package com.peanut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.peanut.api")
@SpringBootApplication
public class PayMain {
    public static void main(String[] args) {
        SpringApplication.run(PayMain.class,args);
    }
}
