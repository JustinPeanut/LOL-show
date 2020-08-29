package com.peanut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Peanut
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.peanut.api"})
public class MemberMain {
    public static void main(String[] args) {
        SpringApplication.run(MemberMain.class,args);
    }
}
