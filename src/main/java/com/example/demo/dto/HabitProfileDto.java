package com.example.demo.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HabitProfileDto {
    private boolean smoking;
    private boolean drinking;
    private LocalTime sleepTime;
    private LocalTime wakeTime;
    private int cleanlinessLevel; // 1-5
    private int noisePreference;  // 1-5
    private String studyStyle;
    private String socialPreference;
    private int visitorsFrequency; // 1-5
}