// src/main/java/com/example/demo/dto/AuthResponse.java
package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public record AuthResponse(String token, Long userId, String email, String role) {}