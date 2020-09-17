package com.dexin.phenixflowerblooming;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan(basePackages = "com.dexin.phenixflowerblooming.mapper")
@SpringBootApplication
public class PhenixflowerbloomingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhenixflowerbloomingApplication.class, args);
    }

}

