package com.quizcontext.handler;

import com.quizcontext.dto.request.UserRequest;
import com.quizcontext.dto.request.UserUpdateRequest;
import com.quizcontext.dto.response.UserResponse;
import com.quizcontext.entity.User;
import com.quizcontext.mapper.UserMapper;
import com.quizcontext.service.UserService;
import java.util.List;
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

  public UserResponse getById(Long id) {
    return userMapper.toResponse(userService.getById(id));
  }

  public List<UserResponse> getAll() {
    return userMapper.toList(userService.getAll());
  }

  public UserResponse update(UserUpdateRequest userUpdateRequest) {
    User user = userMapper.toEntity(userUpdateRequest);
    return userMapper.toResponse(userService.update(user));
  }

  public void delete(Long id) {
    userService.delete(id);
  }
}
