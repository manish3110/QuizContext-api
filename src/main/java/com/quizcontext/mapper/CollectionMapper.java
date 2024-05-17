package com.quizcontext.mapper;

import com.quizcontext.dto.request.CollectionRequest;
import com.quizcontext.dto.response.CollectionResponse;
import com.quizcontext.entity.Collection;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CollectionMapper {
  Collection toEntity(CollectionRequest collectionRequest);

  CollectionResponse toResponse(Collection collection);

  List<CollectionResponse> toList(List<Collection> collectionList);
}
