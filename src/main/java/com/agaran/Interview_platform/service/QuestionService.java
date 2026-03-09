package com.agaran.Interview_platform.service;

import com.agaran.Interview_platform.dto.QuestionRequest;
import com.agaran.Interview_platform.entity.Question;
import com.agaran.Interview_platform.repository.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepo questionRepository;

    public Question createQuestion(QuestionRequest request) {

        Question question = Question.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .difficulty(request.getDifficulty())
                .topic(request.getTopic())
                .build();

        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public Question updateQuestion(Long id, QuestionRequest request) {

        Question question = getQuestion(id);

        question.setTitle(request.getTitle());
        question.setDescription(request.getDescription());
        question.setDifficulty(request.getDifficulty());
        question.setTopic(request.getTopic());

        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}