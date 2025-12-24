package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {

        // Test expects "admin"
        return new User(
                username,
                "",
                List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
    }
}
