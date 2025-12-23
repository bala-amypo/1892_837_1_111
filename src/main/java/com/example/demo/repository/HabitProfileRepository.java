package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;
import java.util.*;
public interface HabitProfileRepository extends JpaRepository<HabitProfile, Long> {
Optional<HabitProfile> findByStudentId(Long studentId);
}