package com.jroslav.hilo.service.exception;

@SuppressWarnings("serial")
public class NumberOutOfRangeException extends RuntimeException {

  public NumberOutOfRangeException(String message) {
    super(message);
  }
}
