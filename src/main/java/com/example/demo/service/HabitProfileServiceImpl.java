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

    private final StudentProfileRepository studentRepo;
    private final HabitProfileRepository habitRepo;

    public HabitProfileServiceImpl(StudentProfileRepository studentRepo, HabitProfileRepository habitRepo) {
        this.studentRepo = studentRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public HabitProfile createOrUpdate(Long studentId, HabitProfileDto dto) {
        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        validateRanges(dto);

        HabitProfile habit = habitRepo.findByStudentId(studentId)
                .orElse(new HabitProfile());

        habit.setStudent(student);
        mapDtoToEntity(dto, habit);
        return habitRepo.save(habit);
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return habitRepo.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit profile not found"));
    }

    private void validateRanges(HabitProfileDto dto) {
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

    private void mapDtoToEntity(HabitProfileDto dto, HabitProfile habit) {
        habit.setSmoking(dto.isSmoking());
        habit.setDrinking(dto.isDrinking());
        habit.setSleepTime(dto.getSleepTime());
        habit.setWakeTime(dto.getWakeTime());
        habit.setCleanlinessLevel(dto.getCleanlinessLevel());
        habit.setNoisePreference(dto.getNoisePreference());
        habit.setStudyStyle(dto.getStudyStyle());
        habit.setSocialPreference(dto.getSocialPreference());
        habit.setVisitorsFrequency(dto.getVisitorsFrequency());
    }
}