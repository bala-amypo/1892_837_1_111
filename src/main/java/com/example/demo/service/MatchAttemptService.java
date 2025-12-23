package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;

public interface MatchAttemptService {
    MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt); //
    List<MatchAttemptRecord> getAllMatchAttempts(); //
    MatchAttemptRecord updateAttemptStatus(Long id, String status); //
    List<MatchAttemptRecord> getAttemptsByStudent(Long studentId); //
}