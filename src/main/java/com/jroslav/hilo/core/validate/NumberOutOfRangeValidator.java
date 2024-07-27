package com.jroslav.hilo.core.validate;

import com.jroslav.hilo.core.exception.NumberOutOfRangeException;
import com.jroslav.hilo.core.localization.Localization;

public class NumberOutOfRangeValidator extends Localization {
  private final int minNumber;
  private final int maxNumber;

  public NumberOutOfRangeValidator(int minNumber, int maxNumber) {
    this.minNumber = minNumber;
    this.maxNumber = maxNumber;
  }

  public boolean validate(int input) throws NumberOutOfRangeException {
    if (input < minNumber || input > maxNumber) {
      throw new NumberOutOfRangeException(messages.getString("RANGE_EXCEPTION"));
    }
    return true;
  }
}
