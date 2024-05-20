package com.quizcontext.dto;

/*
 *Generic Type <T>:
 *T is a placeholder for any type of data you want to store in the response.
 * For example, it could be String, Integer, List, or any custom object.
 */
public record BaseResponse<T>(int resultCode, String resultMessage, T data) {}
