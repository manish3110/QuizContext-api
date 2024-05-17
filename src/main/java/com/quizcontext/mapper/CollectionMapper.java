package com.quizcontext.mapper;

import com.quizcontext.dto.request.CollectionRequest;
import com.quizcontext.dto.request.CollectionUpdateRequest;
import com.quizcontext.dto.response.CollectionResponse;
import com.quizcontext.entity.Collection;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CollectionMapper {
  Collection toEntity(CollectionRequest collectionRequest);

  CollectionResponse toResponse(Collection collection);

  List<CollectionResponse> toList(List<Collection> collectionList);

  Collection toEntity(CollectionUpdateRequest collectionUpdateRequest);

  @Mapping(target = "id", ignore = true)
  Collection toDbEntity(Collection collection, @MappingTarget Collection existCollection);
}
