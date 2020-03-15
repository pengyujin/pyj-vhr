package com.example.controller;

import com.example.exception.MyException;
import com.example.exception.MyExceptionType;
import com.example.common.AjaxResponse;
import com.example.service.HrService;
import com.example.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@Slf4j
public class LoginController {


    @Autowired
    private RedisService redisService;
    @Autowired
    private HrService hrService;

//    @Autowired
//    @Qualifier("jwtUserDetailsService")
//    private UserDetailsService userDetailsService;

//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/login")
    public AjaxResponse login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
//        //无论是有没有token的,登陆的话都重新创建一个token返回
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        String token = jwtTokenUtil.generateToken(userDetails);
//        response.setHeader("token",token);
//        redisService.addToken(token);
        ExecutorService service = Executors.newFixedThreadPool(10);
        return AjaxResponse.success("登陆成功");

    }


}
