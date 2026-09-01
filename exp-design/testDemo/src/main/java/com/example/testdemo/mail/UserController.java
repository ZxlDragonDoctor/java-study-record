package com.example.testdemo.mail;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
//
//@Controller
//@ResponseBody
public class UserController {

    private final MailService mailService;


    public UserController(MailService mailService) {
        this.mailService = mailService;
    }
    // 测试发送注册邮件
    @GetMapping("/test/register")
    public void registerUser(String email) {
        // 用户注册逻辑
        // 注册成功后发送欢迎邮件
        try {
            String subject = "欢迎注册";
            String body = "感谢您的注册，欢迎加入我们的平台！";
            mailService.sendEmail(email, subject, body);
            System.out.println("欢迎邮件已发送！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    // 测试
    @GetMapping("/test")
    public void test() throws MessagingException {
        mailService.sendEmail("3480722102@qq.com", "测试邮件", "这是来自朱小龙的一封测试邮件。");
    }
    // 发送邮件
    @PostMapping("/sendMessage")
    public void test(String email,String subject, String body) throws MessagingException {
        mailService.sendEmail(email, subject, body);
    }
}
