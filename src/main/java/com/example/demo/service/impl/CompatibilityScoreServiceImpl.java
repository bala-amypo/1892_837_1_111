package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    @Override
    public CompatibilityScoreRecord computeScore(Long studentAId, Long studentBId) {
        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setScore(75.0);
        record.setCompatibilityLevel(
                CompatibilityScoreRecord.CompatibilityLevel.HIGH);
        record.setComputedAt(LocalDateTime.now());
        record.setDetailsJson("{}");
        return record;
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setId(id);
        return record;
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return new ArrayList<>();
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return new ArrayList<>();
    }
}
