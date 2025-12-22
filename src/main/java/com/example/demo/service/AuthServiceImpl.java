package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;

    // Use Constructor Injection as required by technical rules
    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponse register(AuthRequest request) {
        // Generates token based on email
        String token = jwtUtil.generateToken(request.getEmail());
        return new AuthResponse(token, request.getEmail(), request.getRole());
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        // MUST match the interface method name 'login' and parameter 'AuthRequest'
        String token = jwtUtil.generateToken(request.getEmail());
        // Returns the response with the token
        return new AuthResponse(token, request.getEmail(), "USER");
    }
}