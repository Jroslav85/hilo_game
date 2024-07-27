package com.jroslav.hilo.core.validate;

import com.jroslav.hilo.core.exception.NonNumericInputException;
import com.jroslav.hilo.core.exception.NumberOutOfRangeException;

public class InputHandler {
  private final NonNumericInputValidator validator;
  private final NumberOutOfRangeValidator rangeValidator;

  public InputHandler(
      NonNumericInputValidator validator, NumberOutOfRangeValidator rangeValidator) {
    this.validator = validator;
    this.rangeValidator = rangeValidator;
  }

  public int parseString(String inputString)
      throws NumberOutOfRangeException, NonNumericInputException {

    int result = 0;
    if (validator.validate(inputString)) {
      result = Integer.parseInt(inputString);
    } else if (rangeValidator.validate(result)) {
      return result;
    }
    return rangeValidate(result);
  }

  private int rangeValidate(int numberChecked) throws NumberOutOfRangeException {
    return rangeValidator.validate(numberChecked) ? numberChecked : 0;
  }
}
