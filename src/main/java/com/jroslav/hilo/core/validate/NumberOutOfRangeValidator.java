package com.jroslav.hilo.core.validate;

import com.jroslav.hilo.core.exception.NumberOutOfRangeException;
import com.jroslav.hilo.core.localization.Localization;

public class NumberOutOfRangeValidator {
  private final int minNumber;
  private final int maxNumber;

  public NumberOutOfRangeValidator(int minNumber, int maxNumber) {
    this.minNumber = minNumber;
    this.maxNumber = maxNumber;
  }

  public void validate(int input) {
    if (input < minNumber || input > maxNumber) {
      throw new NumberOutOfRangeException(Localization.getMessage("hilo.exception.range_message"));
    }
  }
}
