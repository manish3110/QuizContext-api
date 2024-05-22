package com.quizcontext.service;

import com.quizcontext.entity.QuizType;
import java.util.List;

public interface QuizTypeService {
  QuizType create(QuizType quizType);

  QuizType getById(Long id);

  List<QuizType> getAll();

  QuizType update(QuizType quizType);

  void delete(Long id);
}
