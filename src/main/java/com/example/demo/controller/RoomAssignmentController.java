package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-assignments")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RoomAssignmentRecord> assign(
            @RequestBody RoomAssignmentRecord r) {
        return ResponseEntity.ok(service.assignRoom(r));
    }

    @GetMapping
    public ResponseEntity<List<RoomAssignmentRecord>> getAll() {
        return ResponseEntity.ok(service.getAllAssignments());
    }
}
