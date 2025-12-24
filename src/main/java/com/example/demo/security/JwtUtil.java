package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

    private final byte[] key =
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
                .signWith(Keys.hmacShaKeyFor(key))
                .compact();
    }

    public void validate(String token) {
        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token); // throws exception if invalid
    }
}
