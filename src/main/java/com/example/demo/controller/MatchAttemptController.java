package com.example.demo.controller;

import com.example.demo.service.MatchAttemptService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-attempts")
public class MatchAttemptController {
    private final MatchAttemptService attemptService;

    public MatchAttemptController(MatchAttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @PostMapping("/log")
    public ResponseEntity<MatchAttemptRecord> log(@RequestBody MatchAttemptRecord attempt) {
        // Matches test t108
        return ResponseEntity.ok(attemptService.logMatchAttempt(attempt));
    }
}