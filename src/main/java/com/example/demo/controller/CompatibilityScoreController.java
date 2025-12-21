package com.example.demo.controller;

import com.example.demo.service.CompatibilityScoreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compatibility")
@Tag(name = "Compatibility")
public class CompatibilityScoreController {
    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    @PostMapping("/compute/{studentAId}/{studentBId}")
    public Double compute(@PathVariable Long studentAId, @PathVariable Long studentBId) {
        return service.computeScore(studentAId, studentBId);
    }

    @GetMapping("/student/{studentId}")
    public java.util.List<?> getScoresForStudent(@PathVariable Long studentId) {
        return service.getScoresForStudent(studentId);
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        return service.getScoreById(id);
    }

    @GetMapping("/")
    public java.util.List<?> getAll() {
        return service.getAllScores();
    }
}