package com.quizcontext.handler;

import com.quizcontext.dto.request.QuestionTypeRequest;
import com.quizcontext.dto.request.QuestionTypeUpdateRequest;
import com.quizcontext.dto.response.QuestionTypeResponse;
import com.quizcontext.entity.QuestionType;
import com.quizcontext.mapper.QuestionTypeMapper;
import com.quizcontext.service.QuestionTypeService;
import java.util.List;
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

  public List<QuestionTypeResponse> getAll() {
    return questionTypeMapper.toList(questionTypeService.getAll());
  }

  public QuestionTypeResponse getById(Long id) {
    return questionTypeMapper.toResponse(questionTypeService.getById(id));
  }

  public QuestionTypeResponse update(QuestionTypeUpdateRequest questionTypeUpdateRequest) {
    QuestionType questionType = questionTypeMapper.toEntity(questionTypeUpdateRequest);
    return questionTypeMapper.toResponse(questionTypeService.update(questionType));
  }

  public void delete(Long id) {
    questionTypeService.delete(id);
  }
}
