package com.example.demo.repository;

import com.example.demo.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    
    // Method to find a student by their unique Student ID
    Optional<StudentProfile> findByStudentId(String studentId);
    
    // ADD THIS METHOD to resolve the compilation error
    Optional<StudentProfile> findByEmail(String email);
}