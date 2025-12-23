package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import java.util.List;
import java.util.Optional;

public interface HabitProfileService {

    HabitProfile createOrUpdateHabit(HabitProfile habit);

    HabitProfile getHabitByStudent(Long studentId);

    Optional<HabitProfile> getHabitById(Long id);

    List<HabitProfile> getAllHabitProfiles();
}
