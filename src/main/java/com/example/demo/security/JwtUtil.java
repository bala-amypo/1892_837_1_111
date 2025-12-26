package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

@Component   // 🔥 THIS IS THE FIX
public class JwtUtil {

    private static final byte[] KEY =
            "secretkeysecretkeysecretkey12".getBytes();

    public String generateToken(
            String username,
            String role,
            String email,
            String userId) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("email", email)
                .claim("userId", userId)
                .signWith(Keys.hmacShaKeyFor(KEY))
                .compact();
    }

    public void validate(String token) {
        Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token);
    }
}
