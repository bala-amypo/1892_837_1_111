package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;
import java.util.*;


public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
Optional<StudentProfile> findByStudentId(String studentId);
Optional<StudentProfile> findByEmail(String email);
}