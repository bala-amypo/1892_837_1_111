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
    private Double score;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    private LocalDateTime computedAt;

    public enum CompatibilityLevel {
        LOW, MEDIUM, HIGH, EXCELLENT
    }

    public Long getId() { return id; }

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public LocalDateTime getComputedAt() { return computedAt; }
    public void setComputedAt(LocalDateTime computedAt) {
        this.computedAt = computedAt;
    }

    public CompatibilityLevel getCompatibilityLevel() {
        return compatibilityLevel;
    }
    public void setCompatibilityLevel(CompatibilityLevel compatibilityLevel) {
        this.compatibilityLevel = compatibilityLevel;
    }
}
