package com.jroslav.hilo.core;

import com.jroslav.hilo.core.localization.Localization;
import com.jroslav.hilo.core.parser.InputParser;
import com.jroslav.hilo.core.util.NumberGenerator;
import com.jroslav.hilo.core.util.NumericalChecker;
import com.jroslav.hilo.core.validate.NonNumericInputValidator;
import com.jroslav.hilo.core.validate.NumberOutOfRangeValidator;

public class GameContext {
  private InputParser inputParser;
  private NumberGenerator hiddenNumber;
  private NumericalChecker numericalChecker;
  private NonNumericInputValidator inputValidator;
  private NumberOutOfRangeValidator rangeValidator;

  public GameContext(int minNumber, int maxNumber) {
    new Localization();
    hiddenNumber = new NumberGenerator(minNumber, maxNumber);
    inputParser = new InputParser();
    numericalChecker = new NumericalChecker();
    inputValidator = new NonNumericInputValidator();
    rangeValidator = new NumberOutOfRangeValidator(minNumber, maxNumber);
  }

  public InputParser getInputParser() {
    return inputParser;
  }

  public int getHiddenNumber() {
    return hiddenNumber.generate();
  }

  public NumericalChecker getNumericalChecker() {
    return numericalChecker;
  }

  public NonNumericInputValidator getInputValidator() {
    return inputValidator;
  }

  public NumberOutOfRangeValidator getRangeValidator() {
    return rangeValidator;
  }
}
