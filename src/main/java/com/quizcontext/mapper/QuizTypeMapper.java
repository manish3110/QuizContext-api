package com.quizcontext.mapper;

import com.quizcontext.dto.request.QuizTypeRequest;
import com.quizcontext.dto.response.QuizTypeResponse;
import com.quizcontext.entity.QuizType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizTypeMapper {

  QuizType toEntity(QuizTypeRequest quizTypeRequest);

  QuizTypeResponse toResponce(QuizType quizType);
}
