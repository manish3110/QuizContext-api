package com.quizcontext.dto.request;

import jakarta.validation.constraints.NotBlank;

public record QuizTypeRequest(@NotBlank String name) {}
