package com.quizcontext.handler;

import com.quizcontext.dto.request.QuizTypeRequest;
import com.quizcontext.dto.response.QuizTypeResponse;
import com.quizcontext.entity.QuizType;
import com.quizcontext.mapper.QuizTypeMapper;
import org.springframework.stereotype.Component;

@Component
public class QuizTypeHandler {

  private final QuizTypeMapper quizTypeMapper;

  public QuizTypeHandler(final QuizTypeMapper quizTypeMapper) {
    this.quizTypeMapper = quizTypeMapper;
  }

  public QuizTypeResponse create(QuizTypeRequest quizTypeRequest) {

    QuizType quizType = quizTypeMapper.toEntity(quizTypeRequest);
    return quizTypeMapper.toResponse(quizType);
  }
}
