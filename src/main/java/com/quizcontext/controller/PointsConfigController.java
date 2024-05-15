package com.quizcontext.controller;

import com.quizcontext.dto.request.PointsConfigRequest;
import com.quizcontext.dto.response.PointsConfigResponse;
import com.quizcontext.handler.PointsConfigHandler;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pointsconfig")
public class PointsConfigController {

  private final PointsConfigHandler pointsConfigHandler;

  public PointsConfigController(PointsConfigHandler pointsConfigHandler) {
    this.pointsConfigHandler = pointsConfigHandler;
  }

  @PostMapping
  public PointsConfigResponse create(@RequestBody @Valid PointsConfigRequest pointsConfigRequest) {
    PointsConfigResponse pointsConfigResponse = pointsConfigHandler.create(pointsConfigRequest);
    return pointsConfigResponse;
  }
}
