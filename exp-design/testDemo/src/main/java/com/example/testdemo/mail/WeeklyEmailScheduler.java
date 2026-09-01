package com.example.testdemo.mail;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

//@Component
public class WeeklyEmailScheduler {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @PostConstruct
    public void startScheduler() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.start();
    }
}
