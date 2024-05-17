package com.quizcontext.service;

import com.quizcontext.entity.QuestionType;
import java.util.List;

public interface QuestionTypeService {
  QuestionType create(QuestionType questionType);

  List<QuestionType> getAll();

  QuestionType getById(Long id);
}
