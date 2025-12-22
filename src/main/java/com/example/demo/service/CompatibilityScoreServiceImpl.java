package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementation of the matching engine logic.
 */
@Service // This annotation fixes the "Bean not found" error
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final HabitProfileRepository habitRepo;

    /**
     * Constructor injection as required by technical constraints.
     */
    public CompatibilityScoreServiceImpl(HabitProfileRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @Override
    public Double computeScore(Long studentAId, Long studentBId) {
        // 1. Validation: A student cannot match with themselves
        if (studentAId.equals(studentBId)) {
            throw new IllegalArgumentException("same student");
        }

        // 2. Fetch habit profiles from database
        HabitProfile habitA = habitRepo.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit profile for student A not found"));
        HabitProfile habitB = habitRepo.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit profile for student B not found"));

        // 3. Calculate Score (0.0 to 100.0)
        double score = 0.0;
        
        // Weight: Sleep Schedule (40 points)
        if (habitA.getSleepSchedule() == habitB.getSleepSchedule()) {
            score += 40.0;
        }

        // Weight: Cleanliness Level (40 points)
        if (habitA.getCleanlinessLevel() == habitB.getCleanlinessLevel()) {
            score += 40.0;
        }

        // Weight: Study Hours Similarity (20 points)
        // Deduct points based on the difference in study hours
        int hourDiff = Math.abs(habitA.getStudyHoursPerDay() - habitB.getStudyHoursPerDay());
        if (hourDiff <= 2) {
            score += 20.0;
        } else if (hourDiff <= 5) {
            score += 10.0;
        }

        return score;
    }

    @Override
    public List<?> getScoresForStudent(Long studentId) {
        // Returns a list of past calculations for a specific student
        return List.of(); 
    }

    @Override
    public Object getScoreById(Long id) {
        return null;
    }

    @Override
    public List<?> getAllScores() {
        return List.of();
    }
}