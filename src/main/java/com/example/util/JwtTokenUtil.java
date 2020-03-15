//package com.example.util;
//
//import com.example.myPojo.JwtUser;
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.impl.DefaultClock;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cglib.core.internal.Function;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class JwtTokenUtil implements Serializable{
//
//    private static final long serialVersionUID = -3301605591108950415L;
//
//    @Value("${jwt.secret}")
//    private  String secret;
//
//    @Value("${jwt.expiration}")
//    private Long expiration;
//
//    @Value("${jwt.refreshToken}")
//    private Long refreshToken;
//
//    @Value("${jwt.token}")
//    private String tokenHeader;
//
//    private Clock clock = DefaultClock.INSTANCE;
//
//    /**
//     * 生成token令牌
//     * 
//     * @param userDetails
//     * @return
//     */
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return doGenerateToken(claims, userDetails.getUsername());
//    }
//
//    /**
//     * 用claims生成token令牌
//     * 
//     * @param claims
//     * @param subject
//     * @return
//     */
//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//        final Date createdDate = clock.now();
//        final Date expirationDate = calculateExpirationDate(createdDate);
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(createdDate)
//                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    /**
//     * 生成token令牌过期时间
//     * 
//     * @param createdDate
//     * @return
//     */
//    private Date calculateExpirationDate(Date createdDate) {
//        return new Date(createdDate.getTime() + expiration);
//    }
//
//    /**
//     * 验证token令牌是否有效
//     * 
//     * @param token 令牌
//     * @param userDetails 用户信息
//     * @return 是否有效
//     */
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        JwtUser user = (JwtUser) userDetails;
//        final String username = getUsernameFromToken(token);
//        return (username.equals(user.getUsername())
//                && !isTokenExpired(token)
//        );
//    }
//
//    /**
//     * 从token中获取用户名
//     * 
//     * @param token 令牌
//     * @return 用户名
//     */
//    public String getUsernameFromToken(String token) {
//        String username = null;
//        try {
//            username = getClaimFromToken(token, Claims::getSubject);
//        }catch (ExpiredJwtException e) {
//            username = e.getClaims().getSubject();
//        }
//        return username;
//    }
//
//    /**
//     * 从token获取claims
//     * 
//     * @param token 令牌
//     * @param claimsResolver
//     * @param <T>
//     * @return claims
//     */
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    /**
//     * 更新token
//     * @param token
//     * @return
//     */
//    public String refreshToken(String token) {
//        //刷新token是在旧的token没过期，但是为了安全需要更新token
//        //判断刷新时间，是否需要刷新
//        String username = null;
//        Long issuedAt = getIssuedAtFromToken(token).getTime();
//        if( (clock.now().getTime() - issuedAt) >refreshToken) {
//            System.out.println("token超过1分钟，需要刷新");
//            username = getUsernameFromToken(token);
//            Claims claims = getAllClaimsFromToken(token);
//            claims.setExpiration(calculateExpirationDate(new Date()));
//            token = doGenerateToken(claims,username);
//        }
//        return token;
//    }
//
//    /**
//     * 获取claims
//     * 
//     * @param token
//     * @return
//     */
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    /**
//     * 判断令牌是否过期
//     * 
//     * @param token 令牌
//     * @return 是否过期
//     */
//    private Boolean isTokenExpired(String token) {
//
//        Date expiration = null;
//
//        try {
//            expiration = getExpirationDateFromToken(token);
//        }catch (ExpiredJwtException e) {
//            expiration = e.getClaims().getExpiration();
//        }
////        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(clock.now());
//    }
//
//    /**
//     * 从token获取过期时间
//     * @param token
//     * @return
//     */
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    /**
//     * 从token获取发行时间
//     * @param token
//     * @return
//     */
//    public Date getIssuedAtFromToken(String token) {
//        return getClaimFromToken(token, Claims::getIssuedAt);
//    }
//
//}
