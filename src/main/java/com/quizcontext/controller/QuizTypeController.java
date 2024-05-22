package com.quizcontext.controller;

import com.quizcontext.constant.Constant;
import com.quizcontext.dto.BaseResponse;
import com.quizcontext.dto.request.QuizTypeRequest;
import com.quizcontext.dto.request.QuizTypeUpdateRequest;
import com.quizcontext.dto.response.QuizTypeResponse;
import com.quizcontext.enums.ResultCode;
import com.quizcontext.handler.QuizTypeHandler;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiztype")
public class QuizTypeController {

  private final QuizTypeHandler quizTypeHandler;
  private final MessageSource messageSource;

  public QuizTypeController(QuizTypeHandler quizTypeHandler, MessageSource messageSource) {
    this.quizTypeHandler = quizTypeHandler;
    this.messageSource = messageSource;
  }

  @PostMapping
  public BaseResponse<QuizTypeResponse> create(
      @Valid @RequestBody QuizTypeRequest quizTypeRequest) {
    QuizTypeResponse quizTypeResponse = quizTypeHandler.create(quizTypeRequest);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "saved.data.success", new Object[] {Constant.QUIZ_TYPE}, Locale.getDefault()),
        quizTypeResponse);
  }

  @GetMapping("/{id}")
  public BaseResponse<QuizTypeResponse> getById(@PathVariable Long id) {
    QuizTypeResponse quizTypeResponse = quizTypeHandler.getById(id);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "found.data.success", new Object[] {Constant.QUIZ_TYPE}, Locale.getDefault()),
        quizTypeResponse);
  }

  @GetMapping
  public BaseResponse<List<QuizTypeResponse>> getAll() {
    List<QuizTypeResponse> quizTypeResponses = quizTypeHandler.getAll();
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "found.data.success", new Object[] {Constant.QUIZ_TYPE}, Locale.getDefault()),
        quizTypeResponses);
  }

  @PutMapping
  public BaseResponse<QuizTypeResponse> update(
      @RequestBody @Valid QuizTypeUpdateRequest quizTypeUpdateRequest) {
    QuizTypeResponse quizTypeResponse = quizTypeHandler.update(quizTypeUpdateRequest);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "updated.data.success", new Object[] {Constant.QUIZ_TYPE}, Locale.getDefault()),
        quizTypeResponse);
  }

  @DeleteMapping("/{id}")
  public BaseResponse<Void> delete(@PathVariable Long id) {
    quizTypeHandler.delete(id);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "deleted.data.success", new Object[] {Constant.QUIZ_TYPE}, Locale.getDefault()));
  }
}
