package com.quizcontext.mapper;

import com.quizcontext.dto.request.QuestionTypeRequest;
import com.quizcontext.dto.response.QuestionTypeResponse;
import com.quizcontext.entity.QuestionType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionTypeMapper {
  QuestionType toEntity(QuestionTypeRequest questionTypeRequest);

  QuestionTypeResponse toResponse(QuestionType questionType);
}
