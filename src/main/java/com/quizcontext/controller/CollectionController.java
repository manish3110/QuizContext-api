package com.quizcontext.controller;

import com.quizcontext.constant.Constant;
import com.quizcontext.dto.BaseResponse;
import com.quizcontext.dto.request.CollectionRequest;
import com.quizcontext.dto.request.CollectionUpdateRequest;
import com.quizcontext.dto.response.CollectionResponse;
import com.quizcontext.enums.ResultCode;
import com.quizcontext.handler.CollectionHandler;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/collection")
public class CollectionController {
  private final CollectionHandler collectionHandler;
  private final MessageSource messageSource;

  public CollectionController(CollectionHandler collectionHandler, MessageSource messageSource) {
    this.collectionHandler = collectionHandler;
    this.messageSource = messageSource;
  }

  @PostMapping
  public BaseResponse<CollectionResponse> create(
      @RequestBody @Valid CollectionRequest collectionRequest) {
    CollectionResponse collectionResponse = collectionHandler.create(collectionRequest);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "saved.data.success", new Object[] {Constant.COLLECTION}, Locale.getDefault()),
        collectionResponse);
  }

  @GetMapping("/{id}")
  public BaseResponse<CollectionResponse> getById(@PathVariable Long id) {
    CollectionResponse collectionResponse = collectionHandler.getById(id);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "found.data.success", new Object[] {Constant.COLLECTION}, Locale.getDefault()),
        collectionResponse);
  }

  @GetMapping
  public BaseResponse<List<CollectionResponse>> getAll() {
    List<CollectionResponse> collectionResponse = collectionHandler.getAll();
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "found.data.success", new Object[] {Constant.COLLECTION}, Locale.getDefault()),
        collectionResponse);
  }

  @PutMapping
  public BaseResponse<CollectionResponse> update(
      @RequestBody @Valid CollectionUpdateRequest collectionUpdateRequest) {
    CollectionResponse collectionResponse = collectionHandler.update(collectionUpdateRequest);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "updated.data.success", new Object[] {Constant.COLLECTION}, Locale.getDefault()),
        collectionResponse);
  }

  @DeleteMapping("/{id}")
  public BaseResponse<String> delete(@PathVariable Long id) {
    collectionHandler.delete(id);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "deleted.data.success", new Object[] {Constant.COLLECTION}, Locale.getDefault()));
  }
}
