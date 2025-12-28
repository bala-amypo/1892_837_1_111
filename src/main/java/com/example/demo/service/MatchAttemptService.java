package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;

public interface MatchAttemptService {

    MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt);

    List<MatchAttemptRecord> getAttemptsByStudent(Long studentId);

    MatchAttemptRecord getAttemptById(Long id);

    List<MatchAttemptRecord> getAllMatchAttempts();

    // ✅ ADD THIS METHOD
    MatchAttemptRecord updateAttemptStatus(Long id, String status);
}
