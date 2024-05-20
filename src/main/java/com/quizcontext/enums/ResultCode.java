package com.quizcontext.enums;

import lombok.Getter;

@Getter
public enum ResultCode {
  SUCCESS(1001, "SUCCESS");

  private final int code;
  private String message;

  ResultCode(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
