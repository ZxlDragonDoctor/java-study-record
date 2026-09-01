package com.example.testdemo.schedule;
 
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
 
import java.time.LocalDateTime;
 
/**
 * @Description
 * @ClassName MultiThreadTask
 * @Author User
 * @date 2020.06.07 18:56
 */
//@Component
public class MultiThreadTask {

    // @Scheduled执行周期任务会受到上次一个任务的执行时间影响
    // 使用@Async执行多线程任务，不会受到上次任务的执行时间影响
    @Async("taskExecutor")  //指定任务线程池
    @Scheduled(fixedDelay = 1000)  //间隔1秒
    public void first() throws InterruptedException {
        System.out.println("第一个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        Thread.sleep(1000 * 10);
    }
 
    @Async("taskExecutor")
    @Scheduled(fixedDelay = 2000)
    public void second() {
        System.out.println("第二个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
    }
}