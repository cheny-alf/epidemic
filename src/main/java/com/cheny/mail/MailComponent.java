package com.cheny.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailComponent {

    @Autowired
    private JavaMailSender mailSender;

    public void send() {

        System.out.println("发送邮件");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("来自陈师傅的邮件");
        message.setText("不知道说什么的正文");

        message.setTo("2489502883@qq.com");
        message.setFrom("1285682410@qq.com");

        mailSender.send(message);


//        MimeMessage
//        MimeMessageHelper
//        FileSystemResource

        // 发送html格式的邮件  或者附件  可以使用的类和对象
    }

}
