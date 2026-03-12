package com.agaran.Interview_platform.repository;

import com.agaran.Interview_platform.entity.InterviewSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewScheduleRepo extends JpaRepository<InterviewSchedule, Long> {
}
