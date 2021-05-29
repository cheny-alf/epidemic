package com.cheny.util;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailUtil {

    public static void main(String[] args) throws Exception{
        send();
    }

    // 从qq邮箱  发送邮件  到126邮箱
    public static void send() throws Exception{
        // 1) 通过配置构成邮件的会话
        Properties prop = new Properties();
        // 配置协议和服务器地址
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.host","smtp.qq.com");
        prop.setProperty("mail.smtp.auth","true");

        String port = "465";
        prop.setProperty("mail.smtp.port",port);
        prop.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.smtp.socketFactory.fallback","false");
        prop.setProperty("mail.smtp.socketFactory.port",port);

        // 2) 创建会话
        Session session = Session.getInstance(prop);

        // 3) 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        String sendMail = "1285682410@qq.com";
        String Recipients = "2489502883@qq.com";
        message.setFrom(new InternetAddress(sendMail,"cheny","UTF-8"));
        // MimeMessage.RecipientType.CC 抄送  MimeMessage.RecipientType.BCC 密送
        message.setRecipient(MimeMessage.RecipientType.TO ,
                new InternetAddress(Recipients,"cheny","UTF-8"));

        // 标题 正文  发件时间
        message.setSubject("来自陈师傅的问候","UTF-8");
        message.setContent("好好学习，天天向上","text/html;charset=UTF-8");
        message.setSentDate(new Date());

        // 可以保存为 *.eml的文件格式
        message.saveChanges();


        // 4) 获取邮件传输对象  建立连接 并发送
        Transport transport = session.getTransport();
        String accout = "1285682410@qq.com";
        String password = "kgwaneivsrdebafe";
        transport.connect(accout,password);
        transport.sendMessage(message,message.getAllRecipients());

        transport.close();

    }
}
