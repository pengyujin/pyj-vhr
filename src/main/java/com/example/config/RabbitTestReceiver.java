//package com.example.config;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@RabbitListener(queues = "test")
//public class RabbitTestReceiver {
//    
//    @RabbitHandler
//    public void process(String message){
//        System.out.println("接收到："+message);
//    }
//}
