package com.example.demo.controller;

import com.example.demo.service.MatchAttemptService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-attempts")
@Tag(name = "Match Attempts")
public class MatchAttemptController {
    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping("/")
    public Object logAttempt(@RequestBody Object attempt) {
        return service.logMatchAttempt(attempt);
    }

    @PutMapping("/{id}/status")
    public Object updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateAttemptStatus(id, status);
    }

    @GetMapping("/student/{studentId}")
    public java.util.List<?> getByStudent(@PathVariable Long studentId) {
        return service.getAttemptsByStudent(studentId);
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        return service.getAttemptById(id);
    }

    @GetMapping("/")
    public java.util.List<?> getAll() {
        return service.getAllMatchAttempts();
    }
}