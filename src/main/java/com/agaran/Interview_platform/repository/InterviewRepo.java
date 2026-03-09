package com.agaran.Interview_platform.repository;

import com.agaran.Interview_platform.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepo extends JpaRepository<Interview, Long> {
}
