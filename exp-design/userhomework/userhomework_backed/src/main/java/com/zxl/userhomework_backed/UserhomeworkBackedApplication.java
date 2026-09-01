package com.zxl.userhomework_backed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.zxl.userhomework_backed.mapper")
public class UserhomeworkBackedApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserhomeworkBackedApplication.class, args);
    }

}
