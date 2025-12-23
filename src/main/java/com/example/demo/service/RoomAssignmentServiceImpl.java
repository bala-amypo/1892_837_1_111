package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {
    private final RoomAssignmentRecordRepository roomRepo;
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository roomRepo, StudentProfileRepository studentRepo) {
        this.roomRepo = roomRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord r) {
        StudentProfile a = studentRepo.findById(r.getStudentAId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found")); //
        StudentProfile b = studentRepo.findById(r.getStudentBId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        
        if (!a.getActive() || !b.getActive()) {
            throw new IllegalArgumentException("both students must be active"); //
        }
        r.setStatus(RoomAssignmentRecord.Status.ACTIVE);
        return roomRepo.save(r); //
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return roomRepo.findAll();
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return roomRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Override
    public RoomAssignmentRecord updateStatus(Long id, String status) {
        RoomAssignmentRecord r = roomRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        r.setStatus(RoomAssignmentRecord.Status.valueOf(status));
        return roomRepo.save(r); //
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return roomRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }
}