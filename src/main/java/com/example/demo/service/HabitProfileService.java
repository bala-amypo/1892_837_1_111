package com.example.demo.service;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileService {

    private final HabitProfileRepository habitProfileRepository;
    private final StudentProfileRepository studentProfileRepository;

    public HabitProfileService(HabitProfileRepository habitProfileRepository,
                               StudentProfileRepository studentProfileRepository) {
        this.habitProfileRepository = habitProfileRepository;
        this.studentProfileRepository = studentProfileRepository;
    }

    public HabitProfile createOrUpdate(Long studentId, HabitProfileDto dto) {
        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        validateRanges(dto);

        HabitProfile habit = habitProfileRepository.findByStudentId(studentId)
                .orElse(new HabitProfile());

        mapDtoToEntity(dto, habit);
        habit.setStudent(student);

        return habitProfileRepository.save(habit);
    }

    public HabitProfile getForStudent(Long studentId) {
        return habitProfileRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit profile not found"));
    }

    private void validateRanges(HabitProfileDto dto) {
        if (dto.getCleanlinessLevel() < 1 || dto.getCleanlinessLevel() > 5 ||
            dto.getNoisePreference() < 1 || dto.getNoisePreference() > 5 ||
            dto.getVisitorsFrequency() < 1 || dto.getVisitorsFrequency() > 5) {
            throw new IllegalArgumentException("Values must be in range 1-5");
        }
    }

    private void mapDtoToEntity(HabitProfileDto dto, HabitProfile entity) {
        entity.setSmoking(dto.isSmoking());
        entity.setDrinking(dto.isDrinking());
        entity.setSleepTime(dto.getSleepTime());
        entity.setWakeTime(dto.getWakeTime());
        entity.setCleanlinessLevel(dto.getCleanlinessLevel());
        entity.setNoisePreference(dto.getNoisePreference());
        entity.setStudyStyle(dto.getStudyStyle());
        entity.setSocialPreference(dto.getSocialPreference());
        entity.setVisitorsFrequency(dto.getVisitorsFrequency());
    }
}