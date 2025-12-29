package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime assignedAt;

    // ✅ INNER ENUM
    public enum Status {
        ASSIGNED,
        RELEASED
    }

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public LocalDateTime getAssignedAt() { return assignedAt; }
    public void setAssignedAt(LocalDateTime assignedAt) { this.assignedAt = assignedAt; }
}
