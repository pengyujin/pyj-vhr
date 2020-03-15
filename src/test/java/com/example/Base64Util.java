package com.example;

import java.util.Base64;

public class Base64Util {

    public String encode(String s) {
        byte[] encodeBytes = Base64.getEncoder().encode(s.getBytes());
        return new String(encodeBytes);
    }

    public String decode(String s) {
        byte[] decodeBytes = Base64.getDecoder().decode(s.getBytes());
        return new String(decodeBytes);
    }
}
