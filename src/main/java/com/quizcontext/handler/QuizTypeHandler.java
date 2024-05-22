package com.quizcontext.handler;

import com.quizcontext.dto.request.QuizTypeRequest;
import com.quizcontext.dto.request.QuizTypeUpdateRequest;
import com.quizcontext.dto.response.QuizTypeResponse;
import com.quizcontext.entity.QuizType;
import com.quizcontext.mapper.QuizTypeMapper;
import com.quizcontext.service.QuizTypeService;
import jakarta.validation.Valid;
import java.util.List;
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

  public QuizTypeResponse getById(Long id) {
    return quizTypeMapper.toResponce(quizTypeService.getById(id));
  }

  public List<QuizTypeResponse> getAll() {
    return quizTypeMapper.toList(quizTypeService.getAll());
  }

  public QuizTypeResponse update(@Valid QuizTypeUpdateRequest quizTypeUpdateRequest) {
    QuizType quizType = quizTypeMapper.toEntity(quizTypeUpdateRequest);
    return quizTypeMapper.toResponce(quizTypeService.update(quizType));
  }

  public void delete(Long id) {
    quizTypeService.delete(id);
  }
}
