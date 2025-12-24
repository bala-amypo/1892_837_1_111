package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;
import java.util.*;
public interface CompatibilityScoreRecordRepository extends JpaRepository<CompatibilityScoreRecord, Long> {
Optional<CompatibilityScoreRecord> findByStudentAIdAndStudentBId(Long a, Long b);
List<CompatibilityScoreRecord> findByStudentAIdOrStudentBId(Long a, Long b);
}