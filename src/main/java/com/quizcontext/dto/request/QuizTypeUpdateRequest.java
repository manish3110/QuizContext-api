package com.quizcontext.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public record QuizTypeUpdateRequest(@NonNull Long id, @NotBlank String name) {}
