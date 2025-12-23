// src/main/java/com/example/demo/dto/HabitProfileDto.java
package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitProfileDto {
    private boolean smoking;
    private boolean drinking;
    private String sleepTime;
    private String wakeTime;
    private int cleanlinessLevel;
    private int noisePreference;
    private String studyStyle;
    private String socialPreference;
    private int visitorsFrequency;
}