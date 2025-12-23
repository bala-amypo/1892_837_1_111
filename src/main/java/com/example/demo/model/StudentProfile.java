package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_account_id", nullable = false, unique = true)
    private UserAccount userAccount;

    private String name;
    private int age;
    private String course;
    private int yearOfStudy;
    private String gender;

    @Enumerated(EnumType.STRING)
    private RoomType roomTypePreference;

    private LocalTime sleepTime;
    private LocalTime wakeTime;
    private boolean smoking;
    private boolean drinking;
    private int noiseTolerance; // 1-5
    private LocalTime studyTime;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private HabitProfile habitProfile;
}

enum RoomType {
    SINGLE, DOUBLE, TRIPLE
}