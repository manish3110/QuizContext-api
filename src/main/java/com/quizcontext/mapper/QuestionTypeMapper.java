package com.quizcontext.mapper;

import com.quizcontext.dto.request.QuestionTypeRequest;
import com.quizcontext.dto.request.QuestionTypeUpdateRequest;
import com.quizcontext.dto.response.QuestionTypeResponse;
import com.quizcontext.entity.QuestionType;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionTypeMapper {
  QuestionType toEntity(QuestionTypeRequest questionTypeRequest);

  QuestionTypeResponse toResponse(QuestionType questionType);

  List<QuestionTypeResponse> toList(List<QuestionType> questionTypesList);

  QuestionType toEntity(QuestionTypeUpdateRequest questionTypeUpdateRequest);

  @Mapping(target = "id", ignore = true)
  QuestionType toDbEntity(QuestionType questionType, @MappingTarget QuestionType existQuestionType);
}
