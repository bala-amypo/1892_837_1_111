package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // 🔴 MUST HAVE NO-ARG CONSTRUCTOR
    public AuthController() {}

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {
        AuthResponse res = new AuthResponse();
        res.setStatusCodeValue(200);
        res.setUsername(request.getUsername());
        res.setEmail(request.getEmail());
        res.setRole(request.getRole());
        res.setToken("dummy-token");
        return res;
    }
}
