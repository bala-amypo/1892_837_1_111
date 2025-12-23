package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class CompatibilityScoreRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentAId;
    private Long studentBId;
    private Double score;
    private LocalDateTime computedAt;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    public enum CompatibilityLevel { EXCELLENT, GOOD, FAIR, POOR }
}