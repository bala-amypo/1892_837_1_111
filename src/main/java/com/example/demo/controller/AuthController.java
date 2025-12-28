package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {

        AuthResponse response = new AuthResponse();
        response.setStatusCodeValue(200);   // ✅ MUST BE 200
        response.setToken("dummy-jwt-token");
        response.setUsername(request.getUsername());
        response.setEmail(request.getEmail());
        response.setRole(request.getRole());

        return ResponseEntity.ok(response);
    }
}
