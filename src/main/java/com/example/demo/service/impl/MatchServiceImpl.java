// src/main/java/com/example/demo/service/impl/MatchServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.model.MatchResult;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.MatchResultRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final StudentProfileRepository studentRepo;
    private final HabitProfileRepository habitRepo;
    private final MatchResultRepository matchRepo;

    public MatchServiceImpl(StudentProfileRepository studentRepo,
                            HabitProfileRepository habitRepo,
                            MatchResultRepository matchRepo) {
        this.studentRepo = studentRepo;
        this.habitRepo = habitRepo;
        this.matchRepo = matchRepo;
    }

    @Override
    public MatchResult computeMatch(Long studentAId, Long studentBId) {
        StudentProfile studentA = studentRepo.findById(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Student A not found"));
        StudentProfile studentB = studentRepo.findById(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Student B not found"));

        HabitProfile habitA = habitRepo.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit profile for A not found"));
        HabitProfile habitB = habitRepo.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit profile for B not found"));

        double score = calculateCompatibilityScore(habitA, habitB);
        if (score < 0 || score > 100) {
            throw new BadRequestException("Compatibility score must be between 0-100");
        }

        MatchResult result = new MatchResult();
        result.setStudentA(studentA);
        result.setStudentB(studentB);
        result.setScore(score);
        result.setReasonSummary(generateReasonSummary(habitA, habitB));

        // Overwrite existing match for this pair
        matchRepo.findFirstByStudentAIdAndStudentBIdOrStudentBIdAndStudentAIdOrderByCreatedAtDesc(
                studentAId, studentBId, studentAId, studentBId)
                .ifPresent(existing -> {
                    result.setId(existing.getId());
                });

        return matchRepo.save(result);
    }

    @Override
    public List<MatchResult> getMatchesFor(Long studentId) {
        return matchRepo.findByStudentAIdOrStudentBIdOrderByScoreDesc(studentId, studentId);
    }

    @Override
    public MatchResult getById(Long id) {
        return matchRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }

    private double calculateCompatibilityScore(HabitProfile a, HabitProfile b) {
        double score = 0;
        int factors = 0;

        // Smoking & Drinking (high weight)
        if (a.isSmoking() == b.isSmoking()) score += 20;
        if (a.isDrinking() == b.isDrinking()) score += 20;
        factors += 2;

        // Sleep/Wake time difference
        int sleepDiff = Math.abs(timeToMinutes(a.getSleepTime()) - timeToMinutes(b.getSleepTime()));
        int wakeDiff = Math.abs(timeToMinutes(a.getWakeTime()) - timeToMinutes(b.getWakeTime()));
        score += (100 - Math.max(sleepDiff, wakeDiff)) * 0.3; // max 30 points
        factors++;

        // Cleanliness, Noise, Visitors (1-5 scale)
        score += (5 - Math.abs(a.getCleanlinessLevel() - b.getCleanlinessLevel())) * 4; // max 20
        score += (5 - Math.abs(a.getNoisePreference() - b.getNoisePreference())) * 4;
        score += (5 - Math.abs(a.getVisitorsFrequency() - b.getVisitorsFrequency())) * 4;
        factors += 3;

        return Math.round(score / factors * 10.0) / 10.0; // normalized to 0-100
    }

    private int timeToMinutes(String time) {
        if (time == null || !time.matches("\\d{2}:\\d{2}")) return 0;
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String generateReasonSummary(HabitProfile a, HabitProfile b) {
        return "Compatibility based on habits: sleep time, smoking, drinking, cleanliness, noise preference.";
    }
}