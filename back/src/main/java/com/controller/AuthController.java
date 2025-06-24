package com.controller;

import com.annotation.IgnoreAuth;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.TokenService;
import com.utils.AESUtil;
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
    private static final String AES_SECRET = "1234567890123456"; // 必须16/24/32位

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



    @GetMapping("/gen-ticket")
    @IgnoreAuth
    public R genTicket(@RequestParam Map<String, Object> userInfo) {
        try {
            String json = new ObjectMapper().writeValueAsString(userInfo);
            String encrypted = AESUtil.encrypt(json, AES_SECRET);
            return R.ok().put("ticket", encrypted);
        } catch (Exception e) {
            return R.error("生成 ticket 失败");
        }
    }


    @IgnoreAuth
        @GetMapping("/verify-ticket")
    public R verifyTicket(@RequestParam("ticket") String ticket) {
        System.out.println("后端收到 ticket：" + ticket);
        try {
            String json = AESUtil.decrypt(ticket, AES_SECRET);
            System.out.println("解密成功：" + json);
            Map<String, Object> claims = new ObjectMapper().readValue(json, Map.class);
            String username = (String) claims.get("userName");
            System.out.println("解析后"+username);



            return R.ok().put("data", claims);
        } catch (Exception e) {
            e.printStackTrace(); // 查看具体出错位置
            return R.error("ticket 无效");
        }
    }
}
