package com.example.demo.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;


@Component
public class JwtUtil {
private final String secret = "secretkeysecretkeysecretkey12";
public String generateToken(String u,String r,String e,String id){
return Jwts.builder().setSubject(u).claim("role",r).claim("email",e).claim("userId",id)
.signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
}
public void validate(String t){
Jwts.parserBuilder().setSigningKey(secret.getBytes()).build().parseClaimsJws(t);
}
}