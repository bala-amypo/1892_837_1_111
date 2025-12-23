// src/main/java/com/example/demo/controller/StudentProfileController.java
package com.example.demo.controller;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public ResponseEntity<StudentProfile> create(@Valid @RequestBody StudentProfileDto dto,
                                                @RequestParam Long userId) {
        return ResponseEntity.ok(studentProfileService.createProfile(dto, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentProfile> update(@PathVariable Long id,
                                                 @Valid @RequestBody StudentProfileDto dto) {
        return ResponseEntity.ok(studentProfileService.updateProfile(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentProfileService.getProfile(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAll() {
        return ResponseEntity.ok(studentProfileService.getAllProfiles());
    }
}