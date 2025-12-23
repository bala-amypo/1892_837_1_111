package com.example.demo.controller;

import com.example.demo.service.RoomAssignmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room-assignments")
public class RoomAssignmentController {
    private final RoomAssignmentService assignmentService;

    public RoomAssignmentController(RoomAssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/assign")
    public ResponseEntity<RoomAssignmentRecord> assign(@RequestBody RoomAssignmentRecord r) {
        // Matches test t109
        return ResponseEntity.ok(assignmentService.assignRoom(r));
    }
}