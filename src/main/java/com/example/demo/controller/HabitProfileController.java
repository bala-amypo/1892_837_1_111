package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping
    public HabitProfile save(@RequestBody HabitProfile h) {
        return service.createOrUpdateHabit(h);
    }

    @GetMapping("/student/{id}")
    public HabitProfile getByStudent(@PathVariable Long id) {
        return service.getHabitByStudent(id);
    }

    @GetMapping
    public List<HabitProfile> getAll() {
        return service.getAllHabitProfiles();
    }
}
