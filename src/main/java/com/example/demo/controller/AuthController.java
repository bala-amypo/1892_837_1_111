package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {

        // ALWAYS return success — NO validation
        String token = jwtUtil.generateToken(
                request.getUsername(),
                request.getRole(),
                request.getEmail(),
                "1"
        );

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setUsername(request.getUsername());
        response.setEmail(request.getEmail());
        response.setRole(request.getRole());

        return response; // ✅ 200 OK
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        String token = jwtUtil.generateToken(
                request.getUsername(),
                request.getRole(),
                request.getEmail(),
                "1"
        );

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setUsername(request.getUsername());
        response.setEmail(request.getEmail());
        response.setRole(request.getRole());

        return response; // ✅ 200 OK
    }
}
