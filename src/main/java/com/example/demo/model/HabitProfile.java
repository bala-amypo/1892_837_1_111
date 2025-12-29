package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private int studyHoursPerDay;
    private LocalDateTime updatedAt;

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public int getStudyHoursPerDay() { return studyHoursPerDay; }
    public void setStudyHoursPerDay(int studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
