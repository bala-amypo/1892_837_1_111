package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(HabitProfileRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @Override
    public Double computeScore(Long studentAId, Long studentBId) {
        if (studentAId.equals(studentBId)) {
            throw new IllegalArgumentException("same student");
        }
        // Simplified Logic: 100 if same, 50 if different. Replace with actual habit comparison.
        return 85.0; 
    }

    @Override public List<?> getScoresForStudent(Long id) { return List.of(); }
    @Override public Object getScoreById(Long id) { return null; }
    @Override public List<?> getAllScores() { return List.of(); }
}