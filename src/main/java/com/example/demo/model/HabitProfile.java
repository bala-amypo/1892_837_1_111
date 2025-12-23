// src/main/java/com/example/demo/model/HabitProfile.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "habit_profiles")
public class HabitProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id", unique = true)
    private StudentProfile student;

    private boolean smoking;
    private boolean drinking;
    private String sleepTime;
    private String wakeTime;
    private int cleanlinessLevel; // 1-5
    private int noisePreference;  // 1-5
    private String studyStyle;
    private String socialPreference;
    private int visitorsFrequency; // 1-5

    // Getters and Setters (omitted)
}