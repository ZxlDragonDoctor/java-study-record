package com.example.testdemo.schedule;
 

import com.example.testdemo.mapper.ScheduledMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @ClassName MyTask
 * @Author User
 * @date 2020.06.07 15:23
 */
//@Component
@Slf4j
public class MyTask implements SchedulingConfigurer {
 
    @Autowired
    protected ScheduledMapper scheduledMapper;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
 
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(this::process,
                triggerContext -> {
                    String cron = scheduledMapper.getCron(1);
                    if (cron.isEmpty()) {
                        System.out.println("cron is null");
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                });
    }
 
    private void process() {
        log.info("The time now is {} ",dateFormat.format(new Date()));
    }
}