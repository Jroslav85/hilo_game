package com.jroslav.hilo.core.validate;

import com.jroslav.hilo.core.exception.NonNumericInputException;
import com.jroslav.hilo.core.localization.Localization;

public class NonNumericInputValidator {

  public void validate(String input) {
    if (!input.matches("[0-9]+")) {
      throw new NonNumericInputException(Localization.getMessage("hilo.exception.non_numeric_message"));
    }
  }
}
