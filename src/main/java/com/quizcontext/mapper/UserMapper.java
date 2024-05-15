package com.quizcontext.mapper;

import com.quizcontext.dto.request.UserRequest;
import com.quizcontext.dto.response.UserResponse;
import com.quizcontext.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
  User toEntity(UserRequest userRequest);

  UserResponse toResponse(User user);
}
