package com.jroslav.hilo.service.validate;

import com.jroslav.hilo.service.exception.NumberOutOfRangeException;
import com.jroslav.hilo.service.localization.Localization;

public class NumberOutOfRangeValidator extends Localization {
  private final int minNumber;
  private final int maxNumber;

  public NumberOutOfRangeValidator(int minNumber, int maxNumber) {
    this.minNumber = minNumber;
    this.maxNumber = maxNumber;
  }

  public boolean validate(int input) {
    if (input < minNumber || input > maxNumber) {
      throw new NumberOutOfRangeException(messages.getString("RANGE_EXCEPTION"));
    }
    return true;
  }
}
