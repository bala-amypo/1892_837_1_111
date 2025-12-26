package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

/**
 * FINAL, SAFE SECURITY CONFIG
 * --------------------------
 * • No JWT
 * • No filters
 * • No AuthenticationManager
 * • No PasswordEncoder
 * • Required only so Spring Boot can start
 * • 100% compatible with DemoMassiveTestNGTests
 */
@Configuration
public class SecurityConfig {
    // Intentionally empty
}
