package com.example.demo.controller;

import com.example.demo.service.RoomAssignmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room-assignments")
@Tag(name = "Room Assignments")
public class RoomAssignmentController {
    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping("/")
    public Object assignRoom(@RequestBody Object assignment) {
        return service.assignRoom(assignment);
    }

    @PutMapping("/{id}/status")
    public Object updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/student/{studentId}")
    public java.util.List<?> getByStudent(@PathVariable Long studentId) {
        return service.getAssignmentsByStudent(studentId);
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        return service.getAssignmentById(id);
    }

    @GetMapping("/")
    public java.util.List<?> getAll() {
        return service.getAllAssignments();
    }
}