package com.quizcontext.mapper;

import com.quizcontext.dto.request.QuizTypeRequest;
import com.quizcontext.dto.request.QuizTypeUpdateRequest;
import com.quizcontext.dto.response.QuizTypeResponse;
import com.quizcontext.entity.QuizType;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizTypeMapper {

  QuizType toEntity(QuizTypeRequest quizTypeRequest);

  QuizTypeResponse toResponce(QuizType quizType);

  List<QuizTypeResponse> toList(List<QuizType> all);

  QuizType toEntity(QuizTypeUpdateRequest quizTypeUpdateRequest);

  @Mapping(target = "id", ignore = true)
  QuizType toDbEntity(QuizType quizType, @MappingTarget QuizType existQuizType);
}
