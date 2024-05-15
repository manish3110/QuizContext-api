package com.quizcontext.handler;

import com.quizcontext.dto.request.UserRequest;
import com.quizcontext.dto.response.UserResponse;
import com.quizcontext.entity.User;
import com.quizcontext.mapper.UserMapper;
import com.quizcontext.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserHandler {

  private final UserMapper userMapper;
  private final UserService userService;

  public UserHandler(UserMapper userMapper, UserService userService) {
    this.userMapper = userMapper;
    this.userService = userService;
  }

  public UserResponse create(UserRequest userRequest) {
    User user = userMapper.toEntity(userRequest);
    return userMapper.toResponse(userService.create(user));
  }
}
