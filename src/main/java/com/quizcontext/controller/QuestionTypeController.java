package com.quizcontext.controller;

import com.quizcontext.dto.request.QuestionTypeRequest;
import com.quizcontext.dto.response.QuestionTypeResponse;
import com.quizcontext.handler.QuestionTypeHandler;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questiontype")
public class QuestionTypeController {

  private final QuestionTypeHandler questionTypeHandler;

  public QuestionTypeController(QuestionTypeHandler questionTypeHandler) {
    this.questionTypeHandler = questionTypeHandler;
  }

  @PostMapping
  public QuestionTypeResponse create(@RequestBody @Valid QuestionTypeRequest questionTypeRequest) {
    QuestionTypeResponse questionTypeResponse = questionTypeHandler.create(questionTypeRequest);
    return questionTypeResponse;
  }

  @GetMapping("/{id}")
  public QuestionTypeResponse getById(@PathVariable Long id) {
    QuestionTypeResponse questionTypeResponse = questionTypeHandler.getById(id);
    return questionTypeResponse;
  }

  @GetMapping
  public List<QuestionTypeResponse> getAll() {
    List<QuestionTypeResponse> questionTypeResponses = questionTypeHandler.getAll();
    return questionTypeResponses;
  }
}
