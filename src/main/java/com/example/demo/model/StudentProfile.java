package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String email;
    private Boolean active;

    @OneToOne
    private UserAccount userAccount; // Fixes "cannot find symbol UserAccount"

    // Required Getters and Setters to fix "cannot find symbol" errors
    public String getStudentId() { return studentId; }
    public String getEmail() { return email; }
    public void setActive(Boolean active) { this.active = active; }
}