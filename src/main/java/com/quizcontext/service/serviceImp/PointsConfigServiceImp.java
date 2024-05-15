package com.quizcontext.service.serviceImp;

import com.quizcontext.entity.PointsConfig;
import com.quizcontext.repository.PointsConfigRepository;
import com.quizcontext.service.PointsConfigService;
import org.springframework.stereotype.Service;

@Service
public class PointsConfigServiceImp implements PointsConfigService {

  private final PointsConfigRepository pointsConfigRepository;

  public PointsConfigServiceImp(PointsConfigRepository pointsConfigRepository) {
    this.pointsConfigRepository = pointsConfigRepository;
  }

  @Override
  public PointsConfig create(PointsConfig pointsConfig) {
    return pointsConfigRepository.save(pointsConfig);
  }
}
