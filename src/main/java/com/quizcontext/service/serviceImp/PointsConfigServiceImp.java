package com.quizcontext.service.serviceImp;

import com.quizcontext.entity.PointsConfig;
import com.quizcontext.mapper.PointsConfigMapper;
import com.quizcontext.repository.PointsConfigRepository;
import com.quizcontext.service.PointsConfigService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PointsConfigServiceImp implements PointsConfigService {

  private final PointsConfigRepository pointsConfigRepository;
  private final PointsConfigMapper pointsConfigMapper;

  public PointsConfigServiceImp(
      PointsConfigRepository pointsConfigRepository, PointsConfigMapper pointsConfigMapper) {
    this.pointsConfigRepository = pointsConfigRepository;
    this.pointsConfigMapper = pointsConfigMapper;
  }

  @Override
  public PointsConfig create(PointsConfig pointsConfig) {
    return pointsConfigRepository.save(pointsConfig);
  }

  @Override
  public PointsConfig getById(Long id) {
    return pointsConfigRepository.getById(id);
  }

  @Override
  public List<PointsConfig> getAll() {
    return pointsConfigRepository.findAll();
  }

  @Override
  public PointsConfig update(PointsConfig pointsConfig) {
    PointsConfig existPointsConfig = getById(pointsConfig.getId());
    PointsConfig updatedPointsConfig =
        pointsConfigMapper.toDbEntity(pointsConfig, existPointsConfig);
    return pointsConfigRepository.save(updatedPointsConfig);
  }

  @Override
  public void delete(Long id) {
    pointsConfigRepository.deleteById(id);
  }
}
