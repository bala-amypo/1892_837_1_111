// src/main/java/com/example/demo/dto/StudentProfileDto.java
package com.example.demo.dto;

import com.example.demo.model.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileDto {
    private String name;
    private int age;
    private String course;
    private String yearOfStudy;
    private String gender;
    private RoomType roomTypePreference;
    private String sleepTime;
    private String wakeTime;
    private boolean smoking;
    private boolean drinking;
    private int noiseTolerance;
    private String studyTime;
}