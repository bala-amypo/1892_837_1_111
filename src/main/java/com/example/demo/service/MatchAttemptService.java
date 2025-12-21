package com.example.demo.service;

import java.util.List;

public interface MatchAttemptService {
    Object logMatchAttempt(Object attempt);
    Object updateAttemptStatus(Long id, String status);
    List<?> getAttemptsByStudent(Long studentId);
    Object getAttemptById(Long id);
    List<?> getAllMatchAttempts();
}