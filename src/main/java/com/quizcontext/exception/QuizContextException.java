package com.quizcontext.exception;

import lombok.Getter;

@Getter
public class QuizContextException extends RuntimeException {
  private final int resultCode;
  private final String resultMessage;

  public QuizContextException(int resultCode, String resultMessage) {
    this.resultCode = resultCode;
    this.resultMessage = resultMessage;
  }
}
