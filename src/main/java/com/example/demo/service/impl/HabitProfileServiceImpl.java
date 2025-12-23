// src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final StudentProfileRepository studentProfileRepository;
    private final HabitProfileRepository habitProfileRepository;

    public HabitProfileServiceImpl(StudentProfileRepository studentProfileRepository,
                                   HabitProfileRepository habitProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
        this.habitProfileRepository = habitProfileRepository;
    }

    @Override
    public HabitProfile createOrUpdate(Long studentId, HabitProfileDto dto) {
        // Check if student exists
        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        // Validate range-based fields (1-5)
        validateHabitRanges(dto);

        // Find existing habit profile or create new one
        HabitProfile habitProfile = habitProfileRepository.findByStudentId(studentId)
                .orElse(new HabitProfile());

        // Map DTO to entity
        habitProfile.setStudent(student);
        habitProfile.setSmoking(dto.isSmoking());
        habitProfile.setDrinking(dto.isDrinking());
        habitProfile.setSleepTime(dto.getSleepTime());
        habitProfile.setWakeTime(dto.getWakeTime());
        habitProfile.setCleanlinessLevel(dto.getCleanlinessLevel());
        habitProfile.setNoisePreference(dto.getNoisePreference());
        habitProfile.setStudyStyle(dto.getStudyStyle());
        habitProfile.setSocialPreference(dto.getSocialPreference());
        habitProfile.setVisitorsFrequency(dto.getVisitorsFrequency());

        // Save (create or update)
        return habitProfileRepository.save(habitProfile);
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return habitProfileRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit profile not found"));
    }

    private void validateHabitRanges(HabitProfileDto dto) {
        if (dto.getCleanlinessLevel() < 1 || dto.getCleanlinessLevel() > 5) {
            throw new BadRequestException("Cleanliness level must be between 1-5");
        }
        if (dto.getNoisePreference() < 1 || dto.getNoisePreference() > 5) {
            throw new BadRequestException("Noise preference must be between 1-5");
        }
        if (dto.getVisitorsFrequency() < 1 || dto.getVisitorsFrequency() > 5) {
            throw new BadRequestException("Visitors frequency must be between 1-5");
        }
    }
}