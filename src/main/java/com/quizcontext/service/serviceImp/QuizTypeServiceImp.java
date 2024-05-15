package com.quizcontext.service.serviceImp;

import com.quizcontext.entity.QuizType;
import com.quizcontext.repository.QuizTypeRepository;
import com.quizcontext.service.QuizTypeService;
import org.springframework.stereotype.Service;

@Service
public class QuizTypeServiceImp implements QuizTypeService {

  private final QuizTypeRepository quizTypeRepository;

  public QuizTypeServiceImp(QuizTypeRepository quizTypeRepository) {
    this.quizTypeRepository = quizTypeRepository;
  }

  @Override
  public QuizType create(QuizType quizType) {
    return quizTypeRepository.save(quizType);
  }
}
