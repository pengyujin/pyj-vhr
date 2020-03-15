//package com.example.util;
//
//import com.example.myPojo.JwtUser;
//import com.example.service.RedisService;
//import io.jsonwebtoken.ExpiredJwtException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import sun.rmi.runtime.Log;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private RedisService redisService;
//
//    private final JwtUserDetailsService jwtUserDetailsService;
//    private final JwtTokenUtil jwtTokenUtil;
//    private final String tokenHeader;
//
//    public JwtAuthorizationTokenFilter(@Qualifier("jwtUserDetailsService") UserDetailsService userDetailsService,
//                                       JwtTokenUtil jwtTokenUtil, @Value("${jwt.token}") String tokenHeader) {
//        this.jwtUserDetailsService = (JwtUserDetailsService) userDetailsService;
//        this.jwtTokenUtil = jwtTokenUtil;
//        this.tokenHeader = tokenHeader;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//
//        System.out.println("JwtAuthorizationTokenFilter");
//        final String requestHeader = httpServletRequest.getHeader(this.tokenHeader);
//        String username = null;
//        String authToken = null;
//        System.out.println(requestHeader);
//        //有token才会进入
//        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
//            authToken = requestHeader.substring(7);
//            try {
//                username = jwtTokenUtil.getUsernameFromToken(authToken);
//                System.out.println(username);
//            } catch (ExpiredJwtException e) {
//            }
//        }
//        JwtUser jwtUser = null;
//
//        //没有验证Authentication才会进入，login生成token时不会新建context
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            System.out.println("第一次创建context的authentication");
//            jwtUser = jwtUserDetailsService.loadUserByUsername(username);
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//        //验证token是否过期
////        System.out.println(redisService.hasToken(authToken));
//        if(authToken != null && redisService.hasToken(authToken)) {
//            //这里还要验证token是不是最新的token暂时没解决，如果窃取了旧的token，一样可以
//            //先存redis吧
//            if (jwtTokenUtil.validateToken(authToken, jwtUser)) {
//                System.out.println("token未过期,把验证赋给context");
//                System.out.println("需要判断是否要refreshToken");
//                String refreshToken = jwtTokenUtil.refreshToken(authToken);
//                System.out.println(refreshToken);
//                httpServletResponse.setHeader("refreshToken",refreshToken);
//                if(!refreshToken.equals(authToken)) {
//                    redisService.deleteToken(authToken);
//                    redisService.addToken(refreshToken);
//                }
//            }
//        }
////        else {
////            throw new BadCredentialsException("旧的token");
////        }
//
//
//
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
//    }
//
//
//}
