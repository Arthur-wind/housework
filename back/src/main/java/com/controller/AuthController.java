package com.controller;

import com.service.TokenService;
import com.utils.JwtUtils;
import com.utils.R;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/verify-token")

    public R verifyToken(@RequestHeader("Authorization") String authHeader) {

        System.out.println("456");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // 提取 token

            try {
                System.out.println("123");
                Map<String, Object> claims = JwtUtils.parseToken(token);
                System.out.println("解析拿到的token"+token);
                String username = (String) claims.get("userName");
                System.out.println("解析后"+username);
                int userId = (Integer) claims.get("userId");
                String role = (String) claims.get("role");
                String tablename = (String) claims.get("tableName");

                // 可选：从数据库获取用户详细信息
                return R.ok()
                        .put("userId", userId)
                        .put("userName", username)
                        .put("tableName", tablename)
                        .put("role", role);
            } catch (JwtException e) {
                return R.error("token 无效或已过期");
            }
        }
        return R.error("缺少 token");
    }
    // 新增 OPTIONS 方法：让 Spring Boot 明确响应预检请求
    @RequestMapping(value = "/verify-token", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handlePreflight() {
        return ResponseEntity.ok().build();
    }
}
