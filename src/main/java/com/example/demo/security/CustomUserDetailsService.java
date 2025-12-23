package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import java.util.Collections;

public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        return new User(username, "", Collections.emptyList());
    }
}
