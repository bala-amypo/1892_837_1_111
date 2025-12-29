package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private double score;
    private String detailsJson;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    private LocalDateTime computedAt;

    // ✅ INNER ENUM (tests expect this)
    public enum CompatibilityLevel {
        HIGH,
        MEDIUM,
        LOW
    }

    // ✅ Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public String getDetailsJson() { return detailsJson; }
    public void setDetailsJson(String detailsJson) { this.detailsJson = detailsJson; }

    public CompatibilityLevel getCompatibilityLevel() { return compatibilityLevel; }
    public void setCompatibilityLevel(CompatibilityLevel compatibilityLevel) {
        this.compatibilityLevel = compatibilityLevel;
    }

    public LocalDateTime getComputedAt() { return computedAt; }
    public void setComputedAt(LocalDateTime computedAt) { this.computedAt = computedAt; }
}
