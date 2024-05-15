package com.quizcontext.controller;

import com.quizcontext.dto.request.UserRequest;
import com.quizcontext.dto.response.UserResponse;
import com.quizcontext.handler.UserHandler;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
  private final UserHandler userHandler;

  public UserController(UserHandler userHandler) {
    this.userHandler = userHandler;
  }

  @PostMapping
  public UserResponse create(@RequestBody @Valid UserRequest userRequest) {
    UserResponse userResponse = userHandler.create(userRequest);
    return userResponse;
  }
}
