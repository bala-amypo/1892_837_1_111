package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;

import java.time.LocalDateTime;
import java.util.List;

public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(
            CompatibilityScoreRecordRepository scoreRepo,
            HabitProfileRepository habitRepo) {
        this.scoreRepo = scoreRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long studentAId, Long studentBId) {

        if (studentAId.equals(studentBId)) {
            throw new IllegalArgumentException("same student");
        }

        HabitProfile a = habitRepo.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        HabitProfile b = habitRepo.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        double score = 100;

        if (a.getSleepSchedule() != b.getSleepSchedule()) score -= 20;
        if (a.getCleanlinessLevel() != b.getCleanlinessLevel()) score -= 20;
        if (a.getNoiseTolerance() != b.getNoiseTolerance()) score -= 20;
        if (a.getSocialPreference() != b.getSocialPreference()) score -= 20;

        score -= Math.abs(a.getStudyHoursPerDay() - b.getStudyHoursPerDay()) * 2;
        score = Math.max(0, Math.min(100, score));

        CompatibilityScoreRecord record =
                scoreRepo.findByStudentAIdAndStudentBId(studentAId, studentBId)
                        .orElse(new CompatibilityScoreRecord());

        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setScore(score);
        record.setComputedAt(LocalDateTime.now());

        if (score >= 90)
            record.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.EXCELLENT);
        else if (score >= 70)
            record.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.HIGH);
        else if (score >= 40)
            record.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.MEDIUM);
        else
            record.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.LOW);

        return scoreRepo.save(record);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return scoreRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}
