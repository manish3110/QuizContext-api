package com.quizcontext.mapper;

import com.quizcontext.dto.request.PointsConfigRequest;
import com.quizcontext.dto.response.PointsConfigResponse;
import com.quizcontext.entity.PointsConfig;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PointsConfigMapper {

  PointsConfig toEntity(PointsConfigRequest pointsConfigRequest);

  PointsConfigResponse toResponse(PointsConfig pointsConfig);
}
