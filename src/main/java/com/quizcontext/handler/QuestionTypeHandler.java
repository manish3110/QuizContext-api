package com.quizcontext.handler;

import com.quizcontext.dto.request.QuestionTypeRequest;
import com.quizcontext.dto.response.QuestionTypeResponse;
import com.quizcontext.entity.QuestionType;
import com.quizcontext.mapper.QuestionTypeMapper;
import com.quizcontext.service.QuestionTypeService;
import org.springframework.stereotype.Component;

@Component
public class QuestionTypeHandler {

  private final QuestionTypeMapper questionTypeMapper;
  private final QuestionTypeService questionTypeService;

  public QuestionTypeHandler(
      QuestionTypeMapper questionTypeMapper, QuestionTypeService questionTypeService) {
    this.questionTypeMapper = questionTypeMapper;
    this.questionTypeService = questionTypeService;
  }

  public QuestionTypeResponse create(QuestionTypeRequest questionTypeRequest) {
    QuestionType questionType = questionTypeMapper.toEntity(questionTypeRequest);
    return questionTypeMapper.toResponse(questionTypeService.create(questionType));
  }
}
