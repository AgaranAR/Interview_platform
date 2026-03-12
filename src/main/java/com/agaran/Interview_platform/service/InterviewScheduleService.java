package com.agaran.Interview_platform.service;

import com.agaran.Interview_platform.ENUM.ScheduleStatus;
import com.agaran.Interview_platform.dto.ScheduleRequest;
import com.agaran.Interview_platform.entity.Interview;
import com.agaran.Interview_platform.entity.InterviewSchedule;
import com.agaran.Interview_platform.repository.InterviewRepo;
import com.agaran.Interview_platform.repository.InterviewScheduleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterviewScheduleService {

    private final InterviewScheduleRepo scheduleRepository;
    private final InterviewRepo interviewRepository;

    public static InterviewSchedule createSchedule(ScheduleRequest request) {

        Interview interview = interviewRepository.findById(request.getInterviewId())
                .orElseThrow(() -> new RuntimeException("Interview not found"));

        InterviewSchedule schedule = InterviewSchedule.builder()
                .interview(interview)
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .status(ScheduleStatus.SCHEDULED)
                .build();

        return scheduleRepository.save(schedule);
    }
}