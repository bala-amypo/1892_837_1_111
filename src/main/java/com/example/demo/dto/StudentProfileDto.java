package com.example.demo.dto;

import com.example.demo.model.RoomType;
import lombok.Data;

import java.time.LocalTime;

@Data
public class StudentProfileDto {
    private String name;
    private int age;
    private String course;
    private int yearOfStudy;
    private String gender;
    private RoomType roomTypePreference;
    private LocalTime sleepTime;
    private LocalTime wakeTime;
    private boolean smoking;
    private boolean drinking;
    private int noiseTolerance;
    private LocalTime studyTime;
}