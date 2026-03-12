package com.agaran.Interview_platform.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ScheduleRequest {

    private Long interviewId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}