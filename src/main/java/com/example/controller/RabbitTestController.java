//package com.example.controller;
//
//import com.example.config.RabbitTestSender;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 需要安装RabbitMQ
// */
//@RestController
//@RequestMapping("/Rabbit")
//public class RabbitTestController {
//    
//    @Autowired
//    private RabbitTestSender rabbitTestSender;
//    
//    @RequestMapping("/send")
//    public String send() {
//        rabbitTestSender.send();
//        return "OK";
//    }
//}
