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

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    private LocalDateTime computedAt;

    /* ===== TEST EXPECTS THIS ===== */
    public enum CompatibilityLevel {
        HIGH,
        MEDIUM,
        LOW
    }

    // Getters & setters
}
