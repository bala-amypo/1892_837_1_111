package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final Set<String> users = new HashSet<>();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest req) {
        AuthResponse resp = new AuthResponse();

        if (users.contains(req.getUsername())) {
            resp.setStatusCodeValue(400);
            return resp;
        }

        users.add(req.getUsername());
        String token = jwtUtil.generateToken(
                req.getUsername(),
                req.getRole() == null ? "STUDENT" : req.getRole(),
                req.getEmail(),
                "1"
        );

        resp.setStatusCodeValue(200);
        resp.setToken(token);
        resp.setUsername(req.getUsername());
        resp.setEmail(req.getEmail());
        resp.setRole(req.getRole());

        return resp;
    }
}
