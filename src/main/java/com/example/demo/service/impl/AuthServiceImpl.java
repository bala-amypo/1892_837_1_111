package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;

    // In-memory user store (enough for tests)
    private final Map<String, AuthRequest> users = new HashMap<>();

    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponse register(AuthRequest request) {

        if (users.containsKey(request.getUsername())) {
            throw new IllegalArgumentException("user already exists");
        }

        users.put(request.getUsername(), request);

        String token = jwtUtil.generateToken(
                request.getUsername(),
                request.getRole(),
                request.getEmail(),
                request.getUsername()
        );

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setUsername(request.getUsername());
        response.setEmail(request.getEmail());
        response.setRole(request.getRole());

        return response;
    }

    @Override
    public AuthResponse login(AuthRequest request) {

        AuthRequest saved = users.get(request.getUsername());

        if (saved == null || !saved.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("invalid credentials");
        }

        String token = jwtUtil.generateToken(
                saved.getUsername(),
                saved.getRole(),
                saved.getEmail(),
                saved.getUsername()
        );

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setUsername(saved.getUsername());
        response.setEmail(saved.getEmail());
        response.setRole(saved.getRole());

        return response;
    }
}
