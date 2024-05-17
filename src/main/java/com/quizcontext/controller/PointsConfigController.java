package com.quizcontext.controller;

import com.quizcontext.dto.request.PointsConfigRequest;
import com.quizcontext.dto.request.PointsConfigUpdateRequest;
import com.quizcontext.dto.response.PointsConfigResponse;
import com.quizcontext.handler.PointsConfigHandler;
import jakarta.validation.Valid;
import java.util.List;
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

  public PointsConfigController(PointsConfigHandler pointsConfigHandler) {
    this.pointsConfigHandler = pointsConfigHandler;
  }

  @PostMapping
  public PointsConfigResponse create(@RequestBody @Valid PointsConfigRequest pointsConfigRequest) {
    PointsConfigResponse pointsConfigResponse = pointsConfigHandler.create(pointsConfigRequest);
    return pointsConfigResponse;
  }

  @GetMapping("/{id}")
  public PointsConfigResponse getById(@PathVariable Long id) {
    PointsConfigResponse pointsConfigResponse = pointsConfigHandler.getById(id);
    return pointsConfigResponse;
  }

  @GetMapping
  public List<PointsConfigResponse> getAll() {
    List<PointsConfigResponse> pointsConfigResponses = pointsConfigHandler.getAll();
    return pointsConfigResponses;
  }

  @PutMapping
  public PointsConfigResponse update(
      @RequestBody @Valid PointsConfigUpdateRequest pointsConfigUpdateRequest) {
    PointsConfigResponse pointsConfigResponse =
        pointsConfigHandler.update(pointsConfigUpdateRequest);
    return pointsConfigResponse;
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Long id) {
    pointsConfigHandler.delete(id);
    return "Points config deleted sucessfully";
  }
}
