// src/main/java/com/example/demo/controller/HabitProfileController.java
package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.dto.HabitProfileDto;
import com.example.demo.service.HabitProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habits")
public class HabitProfileController {

    private final HabitProfileService habitProfileService;

    public HabitProfileController(HabitProfileService habitProfileService) {
        this.habitProfileService = habitProfileService;
    }

    @PostMapping("/{studentId}")
    public ResponseEntity<HabitProfile> createOrUpdate(@PathVariable Long studentId,
                                                       @Valid @RequestBody HabitProfileDto dto) {
        return ResponseEntity.ok(habitProfileService.createOrUpdate(studentId, dto));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<HabitProfile> getByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(habitProfileService.getForStudent(studentId));
    }
}