//package com.example.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//
///**
// * 邮件发送工具类
// */
//public class EmailUtil {
//
// 
//
//    @Autowired
//    private static JavaMailSender javaMailSender;
//
//    //不带附件
//    public static void sendSimpleMail(String from, String to, String subject, String content){
//        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
//        simpleMailMessage.setFrom(from);
//        simpleMailMessage.setTo(to);
//        simpleMailMessage.setSubject(subject);
//        simpleMailMessage.setText(content);
//        javaMailSender.send(simpleMailMessage);
//    }
//
//    //带附件
//    public static void sendAttachmentMail(String from, String to,String subject,String content,String filePath) throws MessagingException {
//        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
//        mimeMessageHelper.setFrom(from);
//        mimeMessageHelper.setTo(to);
//        mimeMessageHelper.setSubject(subject);
//        mimeMessageHelper.setText(content,true);
//        FileSystemResource fileSystemResource=new FileSystemResource(new File(filePath));
//        String fileName=fileSystemResource.getFilename();
//        mimeMessageHelper.addAttachment(fileName,fileSystemResource);
//        javaMailSender.send(mimeMessage);
//    }
//    
//}
