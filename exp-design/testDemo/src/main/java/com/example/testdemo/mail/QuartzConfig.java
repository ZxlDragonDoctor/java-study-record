package com.example.testdemo.mail;

import com.example.testdemo.mail.AutowiringSpringBeanJobFactory;
import com.example.testdemo.mail.EmailJob;
import org.quartz.*;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

//@Configuration
public class QuartzConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public JobDetail emailJobDetail() {
        return JobBuilder.newJob(EmailJob.class)
                .withIdentity("emailJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger emailJobTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(emailJobDetail())
                .withIdentity("emailJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 8 * * 6")) // 每两分钟执行一次
                .build();
    }

    @Bean
    public AutowiringSpringBeanJobFactory jobFactory() {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, Trigger emailJobTrigger, JobDetail emailJobDetail) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(jobFactory);
        factory.setTriggers(emailJobTrigger);
        factory.setJobDetails(emailJobDetail);
        return factory;
    }
}
