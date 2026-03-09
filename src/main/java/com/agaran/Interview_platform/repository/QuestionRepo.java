package com.agaran.Interview_platform.repository;

import com.agaran.Interview_platform.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {
}