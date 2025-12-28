package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.model.MatchStatus;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository matchRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchAttemptServiceImpl(
            MatchAttemptRecordRepository matchRepo,
            CompatibilityScoreRecordRepository scoreRepo) {
        this.matchRepo = matchRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
        attempt.setAttemptedAt(LocalDateTime.now());
        attempt.setStatus(MatchStatus.PENDING_REVIEW);
        return matchRepo.sav
