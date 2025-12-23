// src/main/java/com/example/demo/model/StudentProfile.java
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}