package com.quizcontext.handler;

import com.quizcontext.dto.request.PointsConfigRequest;
import com.quizcontext.dto.response.PointsConfigResponse;
import com.quizcontext.entity.PointsConfig;
import com.quizcontext.mapper.PointsConfigMapper;
import com.quizcontext.service.PointsConfigService;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PointsConfigHandler {

  private final PointsConfigMapper pointsConfigMapper;
  private final PointsConfigService pointsConfigService;

  public PointsConfigHandler(
      PointsConfigMapper pointsConfigMapper, PointsConfigService pointsConfigService) {
    this.pointsConfigMapper = pointsConfigMapper;
    this.pointsConfigService = pointsConfigService;
  }

  public PointsConfigResponse create(PointsConfigRequest pointsConfigRequest) {
    PointsConfig pointsConfig = pointsConfigMapper.toEntity(pointsConfigRequest);
    return pointsConfigMapper.toResponse(pointsConfigService.create(pointsConfig));
  }

  public PointsConfigResponse getById(Long id) {
    return pointsConfigMapper.toResponse(pointsConfigService.getById(id));
  }

  public List<PointsConfigResponse> getAll() {
    return pointsConfigMapper.toList(pointsConfigService.getAll());
  }
}
