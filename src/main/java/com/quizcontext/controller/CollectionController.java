package com.quizcontext.controller;

import com.quizcontext.dto.request.CollectionRequest;
import com.quizcontext.dto.response.CollectionResponse;
import com.quizcontext.handler.CollectionHandler;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/collection")
public class CollectionController {
  private final CollectionHandler collectionHandler;

  public CollectionController(CollectionHandler collectionHandler) {
    this.collectionHandler = collectionHandler;
  }

  @PostMapping
  public CollectionResponse create(@RequestBody @Valid CollectionRequest collectionRequest) {
    CollectionResponse collectionResponse = collectionHandler.create(collectionRequest);
    return collectionResponse;
  }

  @GetMapping("/{id}")
  public CollectionResponse getById(@PathVariable Long id) {
    CollectionResponse collectionResponse = collectionHandler.getById(id);
    return collectionResponse;
  }

  @GetMapping
  public List<CollectionResponse> getAll() {
    List<CollectionResponse> collectionResponses = collectionHandler.getAll();
    return collectionResponses;
  }
}
