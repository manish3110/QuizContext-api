package com.quizcontext.handler;

import com.quizcontext.dto.request.QuizTypeRequest;
import com.quizcontext.dto.response.QuizTypeResponse;
import com.quizcontext.entity.QuizType;
import com.quizcontext.mapper.QuizTypeMapper;
import com.quizcontext.service.QuizTypeService;
import org.springframework.stereotype.Component;

@Component
public class QuizTypeHandler {

  private final QuizTypeMapper quizTypeMapper;
  private final QuizTypeService quizTypeService;

  public QuizTypeHandler(
      final QuizTypeMapper quizTypeMapper, final QuizTypeService quizTypeService) {
    this.quizTypeMapper = quizTypeMapper;
    this.quizTypeService = quizTypeService;
  }

  public QuizTypeResponse create(QuizTypeRequest quizTypeRequest) {
    QuizType quizType = quizTypeMapper.toEntity(quizTypeRequest);
    return quizTypeMapper.toResponce(quizTypeService.create(quizType));
  }
}
