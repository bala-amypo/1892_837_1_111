package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {
    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        if (repository.findByStudentId(student.getStudentId()).isPresent()) {
            throw new IllegalArgumentException("studentId exists"); //
        }
        return repository.save(student);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found")); //
    }

    @Override
    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile s = getStudentById(id);
        s.setActive(active);
        return repository.save(s); //
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Optional<StudentProfile> findByStudentId(String studentId) {
        return repository.findByStudentId(studentId);
    }
}