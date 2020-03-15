//package com.example.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
////后端解决跨域问题
//@Configuration
//public class CORSConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")		// 允许跨域访问的路径	*表示所有路径,可以更换为URL
//                .allowedOrigins("*")	// 允许跨域访问的源
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")// 允许的请求方式
//                .allowedHeaders("*")	//允许的请求头
//                .allowCredentials(false).maxAge(3600);	// 是否发送cookie
//
//    }
//}
