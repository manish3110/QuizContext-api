package com.quizcontext.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PointsConfigRequest(@NotBlank String name, String description) {}
