package com.example.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class MD5Util {

    private static final String salt = "12345678";

    public static String md5(String src) {
        return DigestUtils.md5DigestAsHex(src.getBytes(StandardCharsets.UTF_8));
    }

    public static String firstMD5(String pwd) {
        String md5lizePWD = salt.charAt(0) + pwd + salt.charAt(3);
        md5lizePWD = md5(md5lizePWD);
        return md5lizePWD;
    }

    public static String secondMD5(String pwd) {
        String md5lizePWD = salt.charAt(0) + pwd + salt.charAt(3);
        md5lizePWD = md5(md5lizePWD);
        return md5lizePWD;
    }

    public static String md5twice(String pwd) {
        return secondMD5(firstMD5(pwd));
    }

    public static void main(String[] args) {
        String pwd = "victor";
        String afterMD5 = md5twice(pwd);
        System.out.println(afterMD5);
    }



}