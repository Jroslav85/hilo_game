package com.jroslav.hilo.core.exception;

@SuppressWarnings("serial")
public class NonNumericInputException extends RuntimeException {

  public NonNumericInputException(String message) {
    super(message);
  }
}
