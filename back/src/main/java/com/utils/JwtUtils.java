package com.utils;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 密钥（建议配置在 application.yml 中）
        private static final String SECRET_KEY = "secretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkey";
    private static final long EXPIRATION = 86400000; // 有效期一天

    public static String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims) // 存放用户信息
                .setSubject(subject) // 主题（可为用户名）
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public static Map<String, Object> parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
