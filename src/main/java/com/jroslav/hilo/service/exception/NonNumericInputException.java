package com.jroslav.hilo.service.exception;

@SuppressWarnings("serial")
public class NonNumericInputException extends RuntimeException {

  public NonNumericInputException(String message) {
    super(message);
  }
}
