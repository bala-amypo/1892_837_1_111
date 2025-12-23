package com.example.demo.service;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;
    private final StudentProfileRepository studentRepo;

    public HabitProfileServiceImpl(HabitProfileRepository habitRepo, StudentProfileRepository studentRepo) {
        this.habitRepo = habitRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public HabitProfile createOrUpdate(Long studentId, HabitProfileDto dto) {
        // Rule: Cleanliness and noise must be 1-5
        if (dto.getCleanlinessLevel() < 1 || dto.getCleanlinessLevel() > 5 ||
            dto.getNoisePreference() < 1 || dto.getNoisePreference() > 5) {
            throw new IllegalArgumentException("Values must be in range 1-5");
        }

        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        // Find existing or create new
        HabitProfile habit = habitRepo.findByStudentId(studentId).orElse(new HabitProfile());
        habit.setStudent(student);
        habit.setCleanlinessLevel(dto.getCleanlinessLevel());
        habit.setNoisePreference(dto.getNoisePreference());
        habit.setSleepTime(dto.getSleepTime());
        habit.setWakeTime(dto.getWakeTime());
        habit.setStudyStyle(dto.getStudyStyle());

        return habitRepo.save(habit);
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return habitRepo.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }
}