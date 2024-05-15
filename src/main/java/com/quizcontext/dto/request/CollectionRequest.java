package com.quizcontext.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CollectionRequest(@NotBlank String name) {}
