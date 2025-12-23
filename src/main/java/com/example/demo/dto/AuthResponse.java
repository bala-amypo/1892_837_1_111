// src/main/java/com/example/demo/dto/AuthResponse.java
package com.example.demo.dto;

public record AuthResponse(String token, Long userId, String email, String role) {}