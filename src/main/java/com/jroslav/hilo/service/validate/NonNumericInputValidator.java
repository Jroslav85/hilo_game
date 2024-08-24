package com.jroslav.hilo.service.validate;

import com.jroslav.hilo.service.exception.NonNumericInputException;
import com.jroslav.hilo.service.localization.Localization;

public class NonNumericInputValidator extends Localization {

  public boolean validate(String input)  {
    try {
      Integer.parseInt(input);
      return true;
    } catch (RuntimeException e) {
      throw new NonNumericInputException(messages.getString("NON_NUMERIC_EXCEPTION"));
    }
  }
}
