package com.example.demo.controller;

import com.example.demo.model.MatchResult;
import com.example.demo.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/compute")
    public ResponseEntity<MatchResult> compute(@RequestParam Long studentAId,
                                               @RequestParam Long studentBId) {
        return ResponseEntity.ok(matchService.computeMatch(studentAId, studentBId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<MatchResult>> getForStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(matchService.getMatchesFor(studentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResult> getById(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getById(id));
    }
}