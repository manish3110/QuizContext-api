package com.quizcontext.mapper;

import com.quizcontext.dto.request.PointsConfigRequest;
import com.quizcontext.dto.request.PointsConfigUpdateRequest;
import com.quizcontext.dto.response.PointsConfigResponse;
import com.quizcontext.entity.PointsConfig;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PointsConfigMapper {

  PointsConfig toEntity(PointsConfigRequest pointsConfigRequest);

  PointsConfigResponse toResponse(PointsConfig pointsConfig);

  List<PointsConfigResponse> toList(List<PointsConfig> all);

  PointsConfig toEntity(PointsConfigUpdateRequest pointsConfigUpdateRequest);

  @Mapping(target = "id", ignore = true)
  PointsConfig toDbEntity(PointsConfig pointsConfig, @MappingTarget PointsConfig existPointsConfig);
}
