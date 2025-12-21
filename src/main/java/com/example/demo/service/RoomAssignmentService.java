package com.example.demo.service;

import java.util.List;

public interface RoomAssignmentService {
    Object assignRoom(Object assignment);
    Object updateStatus(Long id, String status);
    List<?> getAssignmentsByStudent(Long studentId);
    Object getAssignmentById(Long id);
    List<?> getAllAssignments();
}