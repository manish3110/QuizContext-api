package com.quizcontext.controller;

import com.quizcontext.constant.Constant;
import com.quizcontext.dto.BaseResponse;
import com.quizcontext.dto.request.PointsConfigRequest;
import com.quizcontext.dto.request.PointsConfigUpdateRequest;
import com.quizcontext.dto.response.PointsConfigResponse;
import com.quizcontext.enums.ResultCode;
import com.quizcontext.handler.PointsConfigHandler;
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
@RequestMapping("/api/pointsconfig")
public class PointsConfigController {

  private final PointsConfigHandler pointsConfigHandler;
  private final MessageSource messageSource;

  public PointsConfigController(
      PointsConfigHandler pointsConfigHandler, MessageSource messageSource) {
    this.pointsConfigHandler = pointsConfigHandler;
    this.messageSource = messageSource;
  }

  @PostMapping
  public BaseResponse<PointsConfigResponse> create(
      @RequestBody @Valid PointsConfigRequest pointsConfigRequest) {
    PointsConfigResponse pointsConfigResponse = pointsConfigHandler.create(pointsConfigRequest);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "saved.data.success", new Object[] {Constant.POINTS_CONFIG}, Locale.getDefault()),
        pointsConfigResponse);
  }

  @GetMapping("/{id}")
  public BaseResponse<PointsConfigResponse> getById(@PathVariable Long id) {
    PointsConfigResponse pointsConfigResponse = pointsConfigHandler.getById(id);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "found.data.success", new Object[] {Constant.POINTS_CONFIG}, Locale.getDefault()),
        pointsConfigResponse);
  }

  @GetMapping
  public BaseResponse<List<PointsConfigResponse>> getAll() {
    List<PointsConfigResponse> pointsConfigResponses = pointsConfigHandler.getAll();
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "found.data.success", new Object[] {Constant.POINTS_CONFIG}, Locale.getDefault()),
        pointsConfigResponses);
  }

  @PutMapping
  public BaseResponse<PointsConfigResponse> update(
      @RequestBody @Valid PointsConfigUpdateRequest pointsConfigUpdateRequest) {
    PointsConfigResponse pointsConfigResponse =
        pointsConfigHandler.update(pointsConfigUpdateRequest);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "updated.data.success", new Object[] {Constant.POINTS_CONFIG}, Locale.getDefault()),
        pointsConfigResponse);
  }

  @DeleteMapping("/{id}")
  public BaseResponse<Void> delete(@PathVariable Long id) {
    pointsConfigHandler.delete(id);
    return new BaseResponse<>(
        ResultCode.SUCCESS.getCode(),
        messageSource.getMessage(
            "deleted.data.success", new Object[] {Constant.POINTS_CONFIG}, Locale.getDefault()));
  }
}
