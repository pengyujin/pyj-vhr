package com.example;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5是message-digest algorithm 5（信息-摘要算法）的缩写，
 * 被广泛用于加密和解密技术上，它可以说是文件的"数字指纹"。
 * 任何一个文件，无论是可执行程序、图像文件、临时文件或者其他任何类型的文件，也不管它体积多大，
 * 都有且只有一个独一无二的MD5信息值，并且如果这个文件被修改过，它的MD5值也将随之改变。
 * 因此，我们可以通过对比同一文件的MD5值，来校验这个文件是否被"篡改"过。
 * MD5到底有什么用？
 * 当我们下载了文件后，如果想知道下载的这个文件和网站的原始文件是否一模一样，
 * 就可以给自己下载的文件做个MD5校验。如果得到的MD5值和网站公布的相同，可确认所下载的文件是完整的。
 * 如有不同，说明你下载的文件是不完整的：要么就是在网络下载的过程中出现错误，要么就是此文件已被别人修改。
 * 为防止他人更改该文件时放入病毒，最好不要使用。一般正规的站点，都会提供文件md5校验码，这是为了双方都方便。
 */
public class MD5Util {//消息摘要算法

    public String encode(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encodeBytes = md.digest(src.getBytes());

            return Hex.encodeHexString(encodeBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decode(String src) {
        throw new RuntimeException("MD5 no decode");
    }

}
