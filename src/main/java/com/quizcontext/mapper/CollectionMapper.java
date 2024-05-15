package com.quizcontext.mapper;

import com.quizcontext.dto.request.CollectionRequest;
import com.quizcontext.dto.response.CollectionResponse;
import com.quizcontext.entity.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CollectionMapper {
  Collection toEntity(CollectionRequest collectionRequest);

  CollectionResponse toResponse(Collection collection);
}
