package com.keeson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.keeson.mapper")
@SpringBootApplication
public class SpringbootDomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDomeApplication.class, args);
    }



}
