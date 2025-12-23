// src/main/java/com/example/demo/dto/AuthRequest.java
package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public record AuthRequest(String email, String password) {}