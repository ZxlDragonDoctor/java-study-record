package com.example.jwttest;


import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
class JwtTestApplicationTests {
    private String singningKey = "admin";
    // jwt生成token,送至客户端
    @Test
    public void jwt(){
        JwtBuilder jwtBuilder = Jwts.builder();
        String token = jwtBuilder
                // 设置header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                // 设置payload
                .claim("username","tom")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .setId(UUID.randomUUID().toString())
                // 设置签名
                .signWith(SignatureAlgorithm.HS256,singningKey)
                .compact();
        System.out.println(token);
    }
    // 服务端解析token，获取信息
    @Test
    public void parse(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE3NDU5MTU1MzUsImp0aSI6Ijk3YjAzNDJiLTRhMDgtNGJkZi1iNWQyLTNiYjdhOTE3Njg2MyJ9.EMhxBBVFxdobpq2xf8Sl6EYkrUVpMzxAfhqBg8cmv74";
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(singningKey).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        System.out.println(body.getId());
        System.out.println(body.getSubject());
        System.out.println(body.get("username"));
        System.out.println(body.get("role"));
        System.out.println(body.getExpiration());
//        System.out.println(body.getIssuedAt());
//        System.out.println(body.getIssuer());
//        System.out.println(body.getNotBefore());
//        System.out.println(body.getAudience());
    }

}
