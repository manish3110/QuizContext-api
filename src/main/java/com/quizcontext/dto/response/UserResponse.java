package com.quizcontext.dto.response;

public record UserResponse(
    Long id, Boolean is_active, String email, String password, String userName) {}
