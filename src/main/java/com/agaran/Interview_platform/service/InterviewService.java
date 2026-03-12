package com.agaran.Interview_platform.service;

import com.agaran.Interview_platform.dto.InterviewRequest;
import com.agaran.Interview_platform.entity.Interview;
import com.agaran.Interview_platform.entity.Question;
import com.agaran.Interview_platform.repository.InterviewRepo;
import com.agaran.Interview_platform.repository.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewRepo interviewRepository;
    private final QuestionRepo questionRepository;

    public Interview createInterview(InterviewRequest request) {

        Interview interview = Interview.builder()
                .title(request.getTitle())
                .durationMinutes(request.getDurationMinutes())
                .build();

        return interviewRepository.save(interview);
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Interview getInterview(Long id) {
        return interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));
    }

    public Interview addQuestionsToInterview(Long interviewId, List<Long> questionIds) {

        Interview interview = getInterview(interviewId);

        List<Question> questions = questionRepository.findAllById(questionIds);

        interview.setQuestions(questions);

        return interviewRepository.save(interview);
    }
}
