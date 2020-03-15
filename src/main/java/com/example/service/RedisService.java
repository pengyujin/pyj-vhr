package com.example.service;

public interface RedisService {

    void addToken(String token);

    long getTokenExp(String token);

    void deleteToken(String token);

    boolean hasToken(String token);
}
