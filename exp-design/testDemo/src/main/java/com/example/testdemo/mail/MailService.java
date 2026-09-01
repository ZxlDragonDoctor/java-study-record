package com.example.testdemo.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.MailException;
import org.springframework.mail.MailMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

//@Service
public class MailService {

    @Resource
    private  JavaMailSender javaMailSender;

  // 发送普通文件
    public void sendEmail(String to, String subject, String body) throws MessagingException {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("2252406579@qq.com"); // 必须和 spring.mail.username 保持一致
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);

            // 发送邮件
            javaMailSender.send(message);
            System.out.println("邮件已发送！");
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
    // 发送HTML格式的邮件
    public void sendHtmlMail(String to, String subject, String html) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("2252406579@qq.com");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(html, true);

        javaMailSender.send(message);
    }
}
