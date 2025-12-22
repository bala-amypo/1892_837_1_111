package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import org.springframework.stereotype.Service; // CRITICAL IMPORT

@Service // Correct placement
public class AuthServiceImpl implements AuthService {
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
    // ... rest of methods
}