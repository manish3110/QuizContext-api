package com.quizcontext.mapper;

import com.quizcontext.dto.request.UserRequest;
import com.quizcontext.dto.request.UserUpdateRequest;
import com.quizcontext.dto.response.UserResponse;
import com.quizcontext.entity.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
  User toEntity(UserRequest userRequest);

  UserResponse toResponse(User user);

  List<UserResponse> toList(List<User> all);

  @Mapping(target = "id", ignore = true)
  User toDbEntity(User user, @MappingTarget User existUser);

  User toEntity(UserUpdateRequest userUpdateRequest);
}
