// src/main/java/com/example/demo/repository/MatchResultRepository.java
package com.example.demo.repository;

import com.example.demo.model.MatchResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MatchResultRepository extends JpaRepository<MatchResult, Long> {

    List<MatchResult> findByStudentAIdOrStudentBIdOrderByScoreDesc(Long studentAId, Long studentBId);

    // To support overwriting latest match for a pair (ordered by newest first)
    Optional<MatchResult> findFirstByStudentAIdAndStudentBIdOrStudentBIdAndStudentAIdOrderByCreatedAtDesc(
            Long studentA1, Long studentB1, Long studentA2, Long studentB2);
}