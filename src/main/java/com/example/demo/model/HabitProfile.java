package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HabitProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false, unique = true)
    private StudentProfile student;

    private boolean smoking;
    private boolean drinking;
    private LocalTime sleepTime;
    private LocalTime wakeTime;

    private int cleanlinessLevel; // 1-5
    private int noisePreference;  // 1-5
    private String studyStyle;    // e.g., "quiet", "group"
    private String socialPreference; // e.g., "introvert", "extrovert"
    private int visitorsFrequency; // 1-5
}