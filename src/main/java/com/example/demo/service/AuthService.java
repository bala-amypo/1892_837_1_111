package com.example.demo.service;
import org.springframework.stereotype.Service; // ADD THIS IMPORT
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
@Service
public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse login(AuthRequest request);
}