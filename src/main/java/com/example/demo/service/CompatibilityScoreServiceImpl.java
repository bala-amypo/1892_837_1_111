package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {
    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository scoreRepo, HabitProfileRepository habitRepo) {
        this.scoreRepo = scoreRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long studentAId, Long studentBId) {
        if (studentAId.equals(studentBId)) {
            throw new IllegalArgumentException("same student"); //
        }
        HabitProfile a = habitRepo.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found")); //
        HabitProfile b = habitRepo.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double score = 0.0;
        if (a.getSleepSchedule() == b.getSleepSchedule()) score += 25.0;
        if (a.getCleanlinessLevel() == b.getCleanlinessLevel()) score += 25.0;
        if (a.getNoiseTolerance() == b.getNoiseTolerance()) score += 25.0;
        if (a.getSocialPreference() == b.getSocialPreference()) score += 25.0;

        CompatibilityScoreRecord record = scoreRepo.findByStudentAIdAndStudentBId(studentAId, studentBId)
                .orElse(new CompatibilityScoreRecord());
        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setScore(score);
        record.setComputedAt(LocalDateTime.now());
        record.setCompatibilityLevel(score > 80 ? CompatibilityScoreRecord.CompatibilityLevel.EXCELLENT : CompatibilityScoreRecord.CompatibilityLevel.GOOD);
        return scoreRepo.save(record); //
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return scoreRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found")); //
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}