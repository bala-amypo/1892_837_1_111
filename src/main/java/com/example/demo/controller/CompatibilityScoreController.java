package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final CompatibilityScoreService compatService;

    public MatchController(CompatibilityScoreService compatService) {
        this.compatService = compatService;
    }

    @PostMapping("/compute")
    public ResponseEntity<CompatibilityScoreRecord> compute(@RequestParam Long studentAId, @RequestParam Long studentBId) {
        // Triggers the 0-100 score logic
        return ResponseEntity.ok(compatService.computeScore(studentAId, studentBId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<CompatibilityScoreRecord>> getMatchesForStudent(@PathVariable Long studentId) {
        // Returns matches ordered by score descending
        return ResponseEntity.ok(compatService.getScoresForStudent(studentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompatibilityScoreRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(compatService.getScoreById(id));
    }
}