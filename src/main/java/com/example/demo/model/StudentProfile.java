// src/main/java/com/example/demo/model/StudentProfile.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private UserAccount userAccount;

    private String name;
    private int age;
    private String course;
    private String yearOfStudy;
    private String gender;

    @Enumerated(EnumType.STRING)
    private RoomType roomTypePreference;

    private String sleepTime; // e.g., "22:00"
    private String wakeTime;  // e.g., "07:00"
    private boolean smoking;
    private boolean drinking;
    private int noiseTolerance; // 1-5
    private String studyTime;

    // Getters and Setters (omitted for brevity)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserAccount getUserAccount() { return userAccount; }
    public void setUserAccount(UserAccount userAccount) { this.userAccount = userAccount; }

    // ... other getters/setters
}

enum RoomType { SINGLE, DOUBLE, TRIPLE }