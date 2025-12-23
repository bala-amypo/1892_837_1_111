package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService studentService;

    public StudentProfileController(StudentProfileService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public ResponseEntity<StudentProfile> create(@RequestBody StudentProfile student) {
        // Matches test t105 signature
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentProfile>> listAll() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<StudentProfile> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        // Matches test t013
        return ResponseEntity.ok(studentService.updateStudentStatus(id, active));
    }
}