//package com.example.common;
//
//import com.example.pojo.Employee;
//import lombok.AllArgsConstructor;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//
//
///**
// * 邮件发送线程类
// */
//@AllArgsConstructor
//public class EmailRunnable implements Runnable{
//
//    private Employee employee;
//    private JavaMailSender javaMailSender;
//    private String fromAddress;
//    private String subject;
//    private String content;
//
//    @Override
//    public void run() {
//        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
//        simpleMailMessage.setFrom(fromAddress);
//        simpleMailMessage.setTo(employee.getEmail());
//        simpleMailMessage.setSubject(subject);
//        simpleMailMessage.setText(content);
//        javaMailSender.send(simpleMailMessage);
//        
////        带附件
////        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
////        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
////        mimeMessageHelper.setFrom(from);
////        mimeMessageHelper.setTo(to);
////        mimeMessageHelper.setSubject(subject);
////        mimeMessageHelper.setText(content,true);
////        FileSystemResource fileSystemResource=new FileSystemResource(new File(filePath));
////        String fileName=fileSystemResource.getFilename();
////        mimeMessageHelper.addAttachment(fileName,fileSystemResource);
//    }
//}
