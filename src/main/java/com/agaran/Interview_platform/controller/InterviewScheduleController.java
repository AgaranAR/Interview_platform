package com.agaran.Interview_platform.controller;

import com.agaran.Interview_platform.dto.ScheduleRequest;
import com.agaran.Interview_platform.entity.InterviewSchedule;
import com.agaran.Interview_platform.service.InterviewScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class InterviewScheduleController {

    private final InterviewScheduleService interviewScheduleService;

    @PostMapping
    public InterviewSchedule createSchedule(@RequestBody ScheduleRequest scheduleRequest) {
        return interviewScheduleService.createSchedule(scheduleRequest);
    }
}