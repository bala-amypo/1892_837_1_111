package com.example.demo.service;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;
    private final UserAccountRepository userAccountRepository;

    public StudentProfileService(StudentProfileRepository studentProfileRepository,
                                 UserAccountRepository userAccountRepository) {
        this.studentProfileRepository = studentProfileRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public StudentProfile createProfile(StudentProfileDto dto, Long userId) {
        UserAccount user = userAccountRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (studentProfileRepository.findByUserAccountId(userId).isPresent()) {
            throw new IllegalArgumentException("Student profile already exists for this user");
        }

        validateProfile(dto);

        StudentProfile profile = mapToEntity(dto);
        profile.setUserAccount(user);
        return studentProfileRepository.save(profile);
    }

    public StudentProfile updateProfile(Long id, StudentProfileDto dto) {
        StudentProfile profile = studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        validateProfile(dto);
        updateEntityFromDto(profile, dto);
        return studentProfileRepository.save(profile);
    }

    public StudentProfile getProfile(Long id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public List<StudentProfile> getAllProfiles() {
        return studentProfileRepository.findAll();
    }

    private void validateProfile(StudentProfileDto dto) {
        if (dto.getAge() <= 0) {
            throw new IllegalArgumentException("Age must be > 0");
        }
        try {
            com.example.demo.model.RoomType.valueOf(dto.getRoomTypePreference().name());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid room type preference");
        }
    }

    private StudentProfile mapToEntity(StudentProfileDto dto) {
        StudentProfile profile = new StudentProfile();
        updateEntityFromDto(profile, dto);
        return profile;
    }

    private void updateEntityFromDto(StudentProfile profile, StudentProfileDto dto) {
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