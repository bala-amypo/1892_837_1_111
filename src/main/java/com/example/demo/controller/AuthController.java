package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest req) {

        if (users.contains(req.getUsername())) {
            return ResponseEntity.badRequest().build();
        }

        users.add(req.getUsername());

        AuthResponse res = new AuthResponse();
        res.setUsername(req.getUsername());
        res.setEmail(req.getEmail());
        res.setRole(req.getRole());
        res.setToken(jwtUtil.generateToken(
                req.getUsername(),
                req.getRole(),
                req.getEmail(),
                "1"
        ));

        return ResponseEntity.ok(res);
    }
}
