package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {
    private final HabitProfileRepository repository;

    public HabitProfileServiceImpl(HabitProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        if (habit.getStudyHoursPerDay() != null && habit.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("study hours"); //
        }
        Optional<HabitProfile> existing = repository.findByStudentId(habit.getStudentId());
        if (existing.isPresent()) {
            HabitProfile h = existing.get();
            h.setStudyHoursPerDay(habit.getStudyHoursPerDay());
            h.setSleepSchedule(habit.getSleepSchedule());
            // Map other fields...
            return repository.save(h); //
        }
        return repository.save(habit);
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return repository.findById(id);
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return repository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found")); //
    }
}