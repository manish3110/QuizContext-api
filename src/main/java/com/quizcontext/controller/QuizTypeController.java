package com.quizcontext.controller;

import com.quizcontext.dto.request.QuizTypeRequest;
import com.quizcontext.dto.response.QuizTypeResponse;
import com.quizcontext.handler.QuizTypeHandler;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiztype")
public class QuizTypeController {

  private final QuizTypeHandler quizTypeHandler;

  public QuizTypeController(QuizTypeHandler quizTypeHandler) {
    this.quizTypeHandler = quizTypeHandler;
  }

  @PostMapping
  public QuizTypeResponse create(@Valid @RequestBody QuizTypeRequest quizTypeRequest) {
    QuizTypeResponse quizTypeResponse = quizTypeHandler.create(quizTypeRequest);
    return quizTypeResponse;
  }
}
