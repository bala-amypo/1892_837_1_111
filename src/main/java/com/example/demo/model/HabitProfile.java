package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "habit_profiles")
public class HabitProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long studentId; // FK reference to StudentProfile

    private String sleepSchedule; // EARLY / REGULAR / LATE
    private Integer studyHoursPerDay;
    private String cleanlinessLevel; // LOW / MEDIUM / HIGH
    private String noiseTolerance;
    private String socialPreference;
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and Setters
}