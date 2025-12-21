package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String studentId;

    private String fullName;
    private String email;
    private String department;
    private Integer yearLevel;
    private Boolean active;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Add these missing methods manually
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    // Ensure other getters/setters for fullName, email, etc., are also present
    public Long getId() { return id; }
    public String getEmail() { return email; }
}