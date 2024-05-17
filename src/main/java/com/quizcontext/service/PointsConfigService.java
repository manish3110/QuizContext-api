package com.quizcontext.service;

import com.quizcontext.entity.PointsConfig;
import java.util.List;

public interface PointsConfigService {
  PointsConfig create(PointsConfig pointsConfig);

  PointsConfig getById(Long id);

  List<PointsConfig> getAll();
}
