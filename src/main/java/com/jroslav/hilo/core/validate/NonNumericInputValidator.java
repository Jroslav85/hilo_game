package com.jroslav.hilo.core.validate;

import com.jroslav.hilo.core.exception.NonNumericInputException;
import com.jroslav.hilo.core.localization.Localization;

public class NonNumericInputValidator extends Localization {

  public boolean validate(String input) throws NonNumericInputException {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      throw new NonNumericInputException(messages.getString("NON_NUMERIC_EXCEPTION"));
    }
  }
}
