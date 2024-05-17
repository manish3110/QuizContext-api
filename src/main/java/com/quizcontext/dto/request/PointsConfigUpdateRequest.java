package com.quizcontext.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PointsConfigUpdateRequest(
    @NotNull Long id, @NotBlank String name, String description) {}
