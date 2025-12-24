package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match-attempts")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    // Used in TestNG: ctrl.log(attempt)
    @PostMapping
    public ResponseEntity<MatchAttemptRecord> log(
            @RequestBody MatchAttemptRecord attempt) {

        MatchAttemptRecord saved = service.logMatchAttempt(attempt);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<MatchAttemptRecord> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        MatchAttemptRecord updated = service.updateAttemptStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<MatchAttemptRecord>> getByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                service.getAttemptsByStudent(studentId)
        );
    }

    @GetMapping
    public ResponseEntity<List<MatchAttemptRecord>> getAll() {
        return ResponseEntity.ok(service.getAllMatchAttempts());
    }
}
