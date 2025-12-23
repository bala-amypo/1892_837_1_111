package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {
    private final HabitProfileRepository habitRepo;
    private final StudentProfileRepository studentRepo;

    public MatchServiceImpl(HabitProfileRepository habitRepo, StudentProfileRepository studentRepo) {
        this.habitRepo = habitRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public MatchResult computeMatch(Long studentAId, Long studentBId) {
        HabitProfile habitA = habitRepo.findByStudentId(studentAId)
            .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
        HabitProfile habitB = habitRepo.findByStudentId(studentBId)
            .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double score = 0.0;
        // Logic: Compare cleanliness and noise
        if (habitA.getCleanlinessLevel().equals(habitB.getCleanlinessLevel())) score += 50.0;
        if (habitA.getNoisePreference().equals(habitB.getNoisePreference())) score += 50.0;

        // Ensure score is 0-100
        return new MatchResult(studentAId, studentBId, score);
    }
}