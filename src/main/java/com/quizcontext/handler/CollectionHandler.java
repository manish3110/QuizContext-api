package com.quizcontext.handler;

import com.quizcontext.dto.request.CollectionRequest;
import com.quizcontext.dto.response.CollectionResponse;
import com.quizcontext.entity.Collection;
import com.quizcontext.mapper.CollectionMapper;
import com.quizcontext.service.CollectionService;
import org.springframework.stereotype.Component;

@Component
public class CollectionHandler {
  private final CollectionMapper collectionMapper;
  private final CollectionService collectionService;

  public CollectionHandler(CollectionMapper collectionMapper, CollectionService collectionService) {
    this.collectionMapper = collectionMapper;
    this.collectionService = collectionService;
  }

  public CollectionResponse create(CollectionRequest collectionRequest) {
    Collection collection = collectionMapper.toEntity(collectionRequest);
    return collectionMapper.toResponse(collectionService.create(collection));
  }
}
