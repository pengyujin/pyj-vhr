//package com.example.util;
//
//import com.example.myPojo.JwtUser;
//import com.example.pojo.Hr;
//import com.example.pojo.Role;
//import com.example.service.HrService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private HrService hrService;
//
//    @Override
//    public JwtUser loadUserByUsername(String username) throws UsernameNotFoundException {
//        Hr hr = hrService.getByUsername(username);
//        if(hr == null) {
//            throw new UsernameNotFoundException("没有该用户");
//        }
//        System.out.println("JwtUserDetailsService" + "从数据库获取用户的权限");
//        System.out.println("JwtUserDetailsService:" + username);
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        List<Role> roleList = hrService.getRoleListByUsername(username);
//        for (Role role: roleList) {
//            authorityList.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return new JwtUser(username,authorityList);
//    }
//}
