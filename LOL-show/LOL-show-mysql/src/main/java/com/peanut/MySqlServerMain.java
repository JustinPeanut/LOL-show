package com.peanut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Peanut
 */

@MapperScan("com.peanut.mapper")
@SpringBootApplication
public class MySqlServerMain {
    public static void main(String[] args) {
        SpringApplication.run(MySqlServerMain.class,args);
    }
}
