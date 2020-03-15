//package com.example.util;
//
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class MyAccessDeniedHandler implements AccessDeniedHandler {
//    @Override
//    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
//        System.out.println("我是JwtAccessDeinedHandler");
//        httpServletResponse.setCharacterEncoding("UTF-8");
//        httpServletResponse.setContentType("text/javascript;charset=utf-8");
//        httpServletResponse.getWriter().print("权限不足，请联系管理员");
//    }
//}
