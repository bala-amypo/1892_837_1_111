package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MatchAttemptRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime attemptedAt;

    /* ===== TEST EXPECTS THIS ENUM NAME ===== */
    public enum Status {
        SUCCESS,
        FAILED,
        PENDING
    }

    // Getters & setters
}
