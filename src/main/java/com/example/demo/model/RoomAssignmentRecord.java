package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomAssignmentRecord {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String roomNumber;
private Long studentAId;
private Long studentBId;


@Enumerated(EnumType.STRING)
private Status status;


public enum Status {
ACTIVE, COMPLETED, CANCELLED
}
}