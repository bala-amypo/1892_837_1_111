package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ASSIGNED,
        RELEASED
    }

    // Getters & setters
}
