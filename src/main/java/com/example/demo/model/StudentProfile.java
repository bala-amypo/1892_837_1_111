package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    private String name;
    private Integer age;
    private String course;
    private Integer yearOfStudy;
    private String gender;
    private String roomTypePreference; // SINGLE, DOUBLE, TRIPLE
}