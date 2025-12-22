package com.example.demo.security;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentProfileRepository repository;

    /**
     * Constructor injection as required by technical rules.
     */
    public CustomUserDetailsService(StudentProfileRepository repository) {
        this.repository = repository;
    }

    /**
     * Loads the student by email (used as the username in this project).
     * If missing, throws UsernameNotFoundException containing "User not found".
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        StudentProfile student = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // In a real project, the password would come from a UserAccount table.
        // For this student profile, we return a UserDetails object with an empty password
        // as the JwtAuthenticationFilter handles token-based validation.
        return new User(student.getEmail(), "", new ArrayList<>());
    }
}