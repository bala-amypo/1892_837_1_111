package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl {
    private final StudentProfileRepository repository;

    // Strict Constructor Injection
    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    public StudentProfile getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
    
    // Implement other methods: createStudent, findByStudentId, etc.
}