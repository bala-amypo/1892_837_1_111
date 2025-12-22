package com.example.demo.service;

import java.util.List;

public interface CompatibilityScoreService {
    Double computeScore(Long studentAId, Long studentBId);
    List<?> getScoresForStudent(Long studentId);
    Object getScoreById(Long id);
    List<?> getAllScores();
}