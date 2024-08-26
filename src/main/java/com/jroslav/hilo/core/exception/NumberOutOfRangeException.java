package com.jroslav.hilo.core.exception;

@SuppressWarnings("serial")
public class NumberOutOfRangeException extends RuntimeException {

  public NumberOutOfRangeException(String message) {
    super(message);
  }
}
