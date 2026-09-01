package com.example.testdemo;

import com.example.testdemo.mail.WeeklyEmailScheduler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
//@EnableScheduling   // 1.开启定时任务
//@EnableAsync        // 2.开启多线程
public class TestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDemoApplication.class, args);
    }
   //CommandLineRunner 是 Spring Boot 提供的一个便捷接口，
    // 常用于执行启动时的任务，比如初始化数据、启动调度任务等。
//    @Bean
//    public CommandLineRunner run(WeeklyEmailScheduler weeklyEmailScheduler) {
//        return args -> {
//            // 启动定时任务
//            weeklyEmailScheduler.startScheduler();
//        };
//    }
}
