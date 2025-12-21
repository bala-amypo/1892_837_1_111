package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final StudentProfileRepository repository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(StudentProfileRepository repository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse register(AuthRequest request) {
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("email already exists");
        }
        // Save user logic here
        String token = jwtUtil.generateToken(request.getEmail());
        return new AuthResponse(token, request.getEmail(), request.getRole());
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        String token = jwtUtil.generateToken(request.getEmail());
        return new AuthResponse(token, request.getEmail(), "USER");
    }
}