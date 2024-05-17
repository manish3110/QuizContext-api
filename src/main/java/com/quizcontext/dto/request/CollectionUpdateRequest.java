package com.quizcontext.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CollectionUpdateRequest(@NotNull Long id, @NotBlank String name) {}
