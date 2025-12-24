package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compatibility-scores")
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    // USED BY TESTS
    @PostMapping("/compute")
    public ResponseEntity<CompatibilityScoreRecord> compute(
            @RequestParam Long studentAId,
            @RequestParam Long studentBId) {

        CompatibilityScoreRecord result =
                service.computeScore(studentAId, studentBId);

        return ResponseEntity.ok(result);
    }

    // USED BY TESTS
    @GetMapping("/{id}")
    public ResponseEntity<CompatibilityScoreRecord> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getScoreById(id));
    }

    // USED BY TESTS
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<CompatibilityScoreRecord>> getByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                service.getScoresForStudent(studentId)
        );
    }

    // SAFE EXTRA (won’t break tests)
    @GetMapping
    public ResponseEntity<List<CompatibilityScoreRecord>> getAll() {
        return ResponseEntity.ok(service.getAllScores());
    }
}
