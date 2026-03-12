package com.agaran.Interview_platform.controller;
import com.agaran.Interview_platform.dto.InterviewRequest;
import com.agaran.Interview_platform.entity.Interview;
import com.agaran.Interview_platform.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interviews")
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping
    public Interview createInterview(@RequestBody InterviewRequest request) {
        return interviewService.createInterview(request);
    }

    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/{id}")
    public Interview getInterview(@PathVariable Long id) {
        return interviewService.getInterview(id);
    }

    @PostMapping("/{id}/questions")
    public Interview addQuestionsToInterview(@PathVariable Long id,
                                             @RequestBody List<Long> questionIds) {

        return interviewService.addQuestionsToInterview(id, questionIds);
    }
}
