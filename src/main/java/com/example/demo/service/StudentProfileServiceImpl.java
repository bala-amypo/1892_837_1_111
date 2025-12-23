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
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentRepo;
    private final UserAccountRepository userRepo;

    public StudentProfileServiceImpl(StudentProfileRepository studentRepo, UserAccountRepository userRepo) {
        this.studentRepo = studentRepo;
        this.userRepo = userRepo;
    }

    @Override
    public StudentProfile createProfile(StudentProfileDto dto, Long userId) {
        // Rule: Age must be positive
        if (dto.getAge() == null || dto.getAge() <= 0) {
            throw new IllegalArgumentException("Age must be > 0");
        }

        // Rule: Room type must be SINGLE, DOUBLE, or TRIPLE
        String roomPref = dto.getRoomTypePreference();
        if (!List.of("SINGLE", "DOUBLE", "TRIPLE").contains(roomPref)) {
            throw new IllegalArgumentException("Invalid roomTypePreference");
        }

        UserAccount user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Rule: One profile per user
        if (studentRepo.findByUserAccountId(userId).isPresent()) {
            throw new IllegalArgumentException("User already has a profile");
        }

        StudentProfile profile = new StudentProfile();
        profile.setUserAccount(user);
        profile.setName(dto.getName());
        profile.setAge(dto.getAge());
        profile.setCourse(dto.getCourse());
        profile.setYearOfStudy(dto.getYearOfStudy());
        profile.setGender(dto.getGender());
        profile.setRoomTypePreference(roomPref);

        return studentRepo.save(profile);
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return studentRepo.findAll();
    }

    @Override
    public StudentProfile getProfile(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }
}