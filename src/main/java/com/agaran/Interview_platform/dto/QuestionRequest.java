package com.agaran.Interview_platform.dto;

import lombok.Data;

@Data
public class QuestionRequest {

    private String title;

    private String description;

    private String difficulty;

    private String topic;
}
