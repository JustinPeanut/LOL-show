package com.peanut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Peanut
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulMainClass {
    public static void main(String[] args) {

        SpringApplication.run(ZuulMainClass.class,args);

    }

}
