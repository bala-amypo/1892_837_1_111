package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class MatchResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentA;

    @ManyToOne
    private StudentProfile studentB;

    private Double score;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String reasonSummary;
}