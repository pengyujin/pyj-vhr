package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServeImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, String> template;

    @Override
    public void addToken(String token) {

//        String sign = token.split("\\.")[2];
        template.opsForValue().set(token, "1");
//        template.expire(sign,JwtTokenUtil.EXPSECOND, TimeUnit.MILLISECONDS);
    }

    @Override
    public long getTokenExp(String token) {
        String sign = token.split("\\.")[2];
        if (template.hasKey(sign)) {
            return template.getExpire(sign);
        }
        return 0;
    }

    @Override
    public void deleteToken(String token) {
        if (template.hasKey(token)) {
            template.delete(token);
        }
    }

    @Override
    public boolean hasToken(String token) {
        return template.hasKey(token);
    }
}
