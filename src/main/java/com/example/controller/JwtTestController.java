//package com.example.controller;
//
//import com.example.service.HrService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.swing.plaf.synth.SynthOptionPaneUI;
//
//@RestController
//@RequestMapping("/sysUser")
//public class JwtTestController {
//
//    @Autowired
//    private HrService hrService;
//
//    @GetMapping(value = "/test")
//    public String test() {
//        System.out.println(hrService.getRoleListByUsername("admin").get(0));
//        return "Hello Spring Security";
//    }
//
//    @PreAuthorize("hasAnyRole('USER')")
//    @PostMapping(value = "/testNeed")
//    public String testNeed() {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(userDetails.getAuthorities());
//        return "testNeed";
//    }
//
//    @PreAuthorize("hasAnyRole('USERA')")    
//    @PostMapping(value = "/user2")
//    public String user2() {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(userDetails.getAuthorities());
//        System.out.println("user");
//        return "user2";
//    }
//
//    @PreAuthorize("hasAnyRole('admin')")
//    @PostMapping(value = "/admin")
//    public String admin() {
//        System.out.println("admin");
//        return "admin";
//    }
//}
