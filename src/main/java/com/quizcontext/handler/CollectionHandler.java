package com.quizcontext.handler;

import com.quizcontext.dto.request.CollectionRequest;
import com.quizcontext.dto.request.CollectionUpdateRequest;
import com.quizcontext.dto.response.CollectionResponse;
import com.quizcontext.entity.Collection;
import com.quizcontext.mapper.CollectionMapper;
import com.quizcontext.service.CollectionService;
import java.util.List;
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

  public CollectionResponse getById(Long id) {
    return collectionMapper.toResponse(collectionService.getById(id));
  }

  public List<CollectionResponse> getAll() {
    return collectionMapper.toList(collectionService.getAll());
  }

  public CollectionResponse update(CollectionUpdateRequest collectionUpdateRequest) {
    Collection collection = collectionMapper.toEntity(collectionUpdateRequest);
    return collectionMapper.toResponse(collectionService.update(collection));
  }

  public void delete(Long id) {
    collectionService.delete(id);
  }
}
