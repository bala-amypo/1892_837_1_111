package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentProfile student;
    
    private String sleepTime;
    private String wakeTime;
    private Integer cleanlinessLevel; // Range 1-5
    private Integer noisePreference; // Range 1-5
    private String studyStyle;

    // Getters/Setters
    public Integer getCleanlinessLevel() { return cleanlinessLevel; }
    public Integer getNoisePreference() { return noisePreference; }
    // ... other getters and setters
}