//package com.example.myPojo;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.Collection;
//
//public class JwtUser implements UserDetails {
//
//    private String username;
//
//    private String password;
//
//    private Integer state;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public JwtUser(String username, Collection<? extends GrantedAuthority> authorities) {
//        this.username = username;
////        String encode = new BCryptPasswordEncoder().encode("123456");
////        this.setPassword(encode);
//        this.authorities = authorities;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Integer getState() {
//        return state;
//    }
//
//    public void setState(Integer state) {
//        this.state = state;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//
//    //账户是否过期
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    //账户是否被锁
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    //是否启用
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
