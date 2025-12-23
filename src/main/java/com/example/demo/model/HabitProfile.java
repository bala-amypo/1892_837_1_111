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
    @JoinColumn(name = "student_id")
    private StudentProfile student;

    private Integer cleanlinessLevel; // 1-5
    private Integer noisePreference;   // 1-5
    private String sleepTime;
    private String wakeTime;
    private String studyStyle;
}