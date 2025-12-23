// src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository profileRepo;
    private final UserAccountRepository userRepo;

    public StudentProfileServiceImpl(StudentProfileRepository profileRepo, UserAccountRepository userRepo) {
        this.profileRepo = profileRepo;
        this.userRepo = userRepo;
    }

    @Override
    public StudentProfile createProfile(StudentProfileDto dto, Long userId) {
        UserAccount user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (profileRepo.findByUserAccountId(userId).isPresent()) {
            throw new BadRequestException("User already has a profile");
        }

        validateDto(dto);

        StudentProfile profile = new StudentProfile();
        profile.setUserAccount(user);
        mapDtoToEntity(dto, profile);
        return profileRepo.save(profile);
    }

    @Override
    public StudentProfile updateProfile(Long id, StudentProfileDto dto) {
        StudentProfile profile = getProfile(id);
        validateDto(dto);
        mapDtoToEntity(dto, profile);
        return profileRepo.save(profile);
    }

    @Override
    public StudentProfile getProfile(Long id) {
        return profileRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return profileRepo.findAll();
    }

    private void validateDto(StudentProfileDto dto) {
        if (dto.getAge() <= 0) {
            throw new BadRequestException("Age must be > 0");
        }
        // Add more validations if needed
    }

    private void mapDtoToEntity(StudentProfileDto dto, StudentProfile profile) {
        profile.setName(dto.getName());
        profile.setAge(dto.getAge());
        profile.setCourse(dto.getCourse());
        profile.setYearOfStudy(dto.getYearOfStudy());
        profile.setGender(dto.getGender());
        profile.setRoomTypePreference(dto.getRoomTypePreference());
        profile.setSleepTime(dto.getSleepTime());
        profile.setWakeTime(dto.getWakeTime());
        profile.setSmoking(dto.isSmoking());
        profile.setDrinking(dto.isDrinking());
        profile.setNoiseTolerance(dto.getNoiseTolerance());
        profile.setStudyTime(dto.getStudyTime());
    }
}