package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;
    
    private String name;
    private Integer age;
    private String course;
    private Integer yearOfStudy;
    private String gender;
    private String roomTypePreference; // SINGLE, DOUBLE, TRIPLE
    
    // Standard Getters/Setters
    public Long getId() { return id; }
    public void setAge(Integer age) { this.age = age; }
    public Integer getAge() { return age; }
    // ... other getters and setters
}