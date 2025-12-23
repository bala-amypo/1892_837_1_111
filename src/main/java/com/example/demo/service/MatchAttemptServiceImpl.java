package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.MatchAttemptRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {
    private final MatchAttemptRecordRepository matchRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository matchRepo, CompatibilityScoreRecordRepository scoreRepo) {
        this.matchRepo = matchRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
        if (attempt.getResultScoreId() != null) {
            CompatibilityScoreRecord score = scoreRepo.findById(attempt.getResultScoreId()).orElse(null);
            if (score != null && score.getScore() >= 80) {
                attempt.setStatus(MatchAttemptRecord.Status.MATCHED); //
            } else {
                attempt.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW); //
            }
        } else {
            attempt.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW);
        }
        return matchRepo.save(attempt);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return matchRepo.findAll();
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
        MatchAttemptRecord a = matchRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        a.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return matchRepo.save(a); //
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId) {
        return matchRepo.findByInitiatorStudentIdOrCandidateStudentId(studentId, studentId);
    }
}