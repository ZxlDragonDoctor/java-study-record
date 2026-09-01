package com.example.testdemo.mail;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
//
//@Component
public class EmailJob implements Job {

    @Resource
    private  MailService mailService;


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            String recipient = "xxxxxx@qq.com";  // 收件人邮箱
            String subject = "每周提醒";
            String body = "约吗？";
            mailService.sendEmail(recipient, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
