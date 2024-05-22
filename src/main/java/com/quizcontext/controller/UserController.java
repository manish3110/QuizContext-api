package com.quizcontext.controller;

import com.quizcontext.constant.Constant;
import com.quizcontext.dto.BaseResponse;
import com.quizcontext.dto.request.UserRequest;
import com.quizcontext.dto.request.UserUpdateRequest;
import com.quizcontext.dto.response.UserResponse;
import com.quizcontext.enums.ResultCode;
import com.quizcontext.handler.UserHandler;
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
@RequestMapping("/api/user")
public class UserController {
  private final UserHandler userHandler;
  private final MessageSource messageSource;

  public UserController(UserHandler userHandler, MessageSource messageSource) {
    this.userHandler = userHandler;
    this.messageSource = messageSource;
  }

  @PostMapping
  public BaseResponse<UserResponse> create(@RequestBody @Valid UserRequest userRequest) {
    UserResponse userResponse = userHandler.create(userRequest);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "saved.data.success", new Object[] {Constant.USER}, Locale.getDefault()),
        userResponse);
  }

  @GetMapping("/{id}")
  public BaseResponse<UserResponse> getById(@PathVariable Long id) {
    UserResponse userResponse = userHandler.getById(id);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "found.data.success", new Object[] {Constant.USER}, Locale.getDefault()),
        userResponse);
  }

  @GetMapping
  public BaseResponse<List<UserResponse>> getAll() {
    List<UserResponse> userResponses = userHandler.getAll();
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "found.data.success", new Object[] {Constant.USER}, Locale.getDefault()),
        userResponses);
  }

  @PutMapping
  public BaseResponse<UserResponse> update(
      @RequestBody @Valid UserUpdateRequest userUpdateRequest) {
    UserResponse userResponse = userHandler.update(userUpdateRequest);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "updated.data.success", new Object[] {Constant.USER}, Locale.getDefault()),
        userResponse);
  }

  @DeleteMapping("/{id}")
  public BaseResponse<Void> delete(@PathVariable Long id) {
    userHandler.delete(id);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "deleted.data.success", new Object[] {Constant.USER}, Locale.getDefault()));
  }
}
