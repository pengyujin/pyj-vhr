//package com.example.config;
//
//import com.example.util.MyAccessDeniedHandler;
//import com.example.util.JwtAuthenticationEntryPoint;
//import com.example.util.JwtAuthorizationTokenFilter;
//import com.example.util.JwtUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * springsercurity安全框架
// */
////AOP
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @Autowired
//    private JwtUserDetailsService jwtUserDetailsService;
//
//    @Autowired
//    private JwtAuthorizationTokenFilter jwtAuthorizationTokenFilter;
//
//    @Autowired
//    private MyAccessDeniedHandler myAccessDeniedHandler;
//
//
//
//    //重写方法
//
//    //链式编程
//    //授权
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests().antMatchers("/**").permitAll();
//        //首页所有人都可以访问，功能页只有对应权限的人才能访问
////        http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
////                .accessDeniedHandler(myAccessDeniedHandler)
////                .and()
////                .authorizeRequests()
////                .antMatchers("/login").permitAll()
////                .antMatchers("/haha").permitAll()
////                .antMatchers("/sysUser/test").permitAll()
////                .antMatchers(HttpMethod.OPTIONS,"/**").anonymous()
////                .anyRequest().authenticated()// 剩下所有的验证都需要验证
////                .and()
////                .csrf().disable()// 禁用 Spring Security 自带的跨域处理
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .addFilterBefore(jwtAuthorizationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        
//    }
//
//    //认证
//    //密码编码：passwordEncoder
//    //在Spring Security 5.0+ 新增了很多的加密方法
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoderBean());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoderBean() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    /**
//     *  这个方法的作用时声明哪些页面不需要权限验证
//     * @param web
//     * @throws Exception
//     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/swagger-ui.html")
//                .antMatchers("/v2/**")
//                .antMatchers("/swagger-resources/**");
//    }
//
//}
