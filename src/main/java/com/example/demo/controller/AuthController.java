package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;
    public AuthController(AuthService service) { this.service = service; }

    @PostMapping("/register") public AuthResponse register(@RequestBody AuthRequest req) { return service.register(req); }
    @PostMapping("/login") public AuthResponse login(@RequestBody AuthRequest req) { return service.login(req); }
}