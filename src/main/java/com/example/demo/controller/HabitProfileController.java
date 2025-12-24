package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HabitProfile> save(@RequestBody HabitProfile h) {
        return ResponseEntity.ok(service.createOrUpdateHabit(h));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<HabitProfile> getByStudent(@PathVariable Long id) {
        return ResponseEntity.ok(service.getHabitByStudent(id));
    }

    @GetMapping
    public ResponseEntity<List<HabitProfile>> getAll() {
        return ResponseEntity.ok(service.getAllHabitProfiles());
    }
}
