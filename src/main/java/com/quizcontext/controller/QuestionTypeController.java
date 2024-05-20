package com.quizcontext.controller;

import com.quizcontext.constant.Constant;
import com.quizcontext.dto.BaseResponse;
import com.quizcontext.dto.request.QuestionTypeRequest;
import com.quizcontext.dto.request.QuestionTypeUpdateRequest;
import com.quizcontext.dto.response.QuestionTypeResponse;
import com.quizcontext.enums.ResultCode;
import com.quizcontext.handler.QuestionTypeHandler;
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
@RequestMapping("/api/questiontype")
public class QuestionTypeController {

  private final QuestionTypeHandler questionTypeHandler;
  private final MessageSource messageSource;

  public QuestionTypeController(
      QuestionTypeHandler questionTypeHandler, MessageSource messageSource) {
    this.questionTypeHandler = questionTypeHandler;
    this.messageSource = messageSource;
  }

  @PostMapping
  public BaseResponse<QuestionTypeResponse> create(
      @RequestBody @Valid QuestionTypeRequest questionTypeRequest) {
    QuestionTypeResponse questionTypeResponse = questionTypeHandler.create(questionTypeRequest);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "saved.data.success", new Object[] {Constant.QUESTION_TYPE}, Locale.getDefault()),
        questionTypeResponse);
  }

  @GetMapping("/{id}")
  public BaseResponse<QuestionTypeResponse> getById(@PathVariable Long id) {
    QuestionTypeResponse questionTypeResponse = questionTypeHandler.getById(id);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "found.data.success", new Object[] {Constant.QUESTION_TYPE}, Locale.getDefault()),
        questionTypeResponse);
  }

  @GetMapping
  public BaseResponse<List<QuestionTypeResponse>> getAll() {
    List<QuestionTypeResponse> questionTypeResponses = questionTypeHandler.getAll();
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "found.data.success", new Object[] {Constant.QUESTION_TYPE}, Locale.getDefault()),
        questionTypeResponses);
  }

  @PutMapping
  public BaseResponse<QuestionTypeResponse> update(
      @RequestBody @Valid QuestionTypeUpdateRequest questionTypeUpdateRequest) {
    QuestionTypeResponse questionTypeResponse =
        questionTypeHandler.update(questionTypeUpdateRequest);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "updated.data.success", new Object[] {Constant.QUESTION_TYPE}, Locale.getDefault()),
        questionTypeResponse);
  }

  @DeleteMapping("/{id}")
  public BaseResponse<Void> delete(@PathVariable Long id) {
    questionTypeHandler.delete(id);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "deleted.data.success", new Object[] {Constant.QUESTION_TYPE}, Locale.getDefault()));
  }
}
