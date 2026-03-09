package com.agaran.Interview_platform.repository;

import com.agaran.Interview_platform.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepo extends JpaRepository<Submission, Long> {
}
