package com.peanut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.peanut.api"})
public class MarketMain {
    public static void main(String[] args) {
        SpringApplication.run(MarketMain.class,args);
    }
}
