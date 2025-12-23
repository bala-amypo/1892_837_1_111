package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"student_a_id", "student_b_id"}))
public class MatchResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_a_id")
    private StudentProfile studentA;

    @ManyToOne
    @JoinColumn(name = "student_b_id")
    private StudentProfile studentB;

    private double score; // 0-100

    private LocalDateTime createdAt = LocalDateTime.now();

    private String reasonSummary;
}