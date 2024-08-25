package com.jroslav.hilo.service;

import com.jroslav.hilo.service.util.NumberGenerator;
import com.jroslav.hilo.service.validate.InputHandler;
import com.jroslav.hilo.service.validate.NonNumericInputValidator;
import com.jroslav.hilo.service.validate.NumberOutOfRangeValidator;

public class GameContext {
  private InputHandler inputHandler;
  private NonNumericInputValidator inputValidator;
  private NumberGenerator hiddenNumber;
  private NumericalChecker numericalChecker;
  private NumberOutOfRangeValidator rangeValidator;

  public GameContext(int minNumber, int maxNumber) {
    hiddenNumber = new NumberGenerator(minNumber, maxNumber);
    inputValidator = new NonNumericInputValidator();
    rangeValidator = new NumberOutOfRangeValidator(minNumber, maxNumber);
    inputHandler = new InputHandler(inputValidator, rangeValidator);
    numericalChecker = new NumericalChecker();
  }

  public InputHandler getInputHandler() {
    return inputHandler;
  }

  public int getHiddenNumber() {
    return hiddenNumber.generate();
  }

  public NumericalChecker getNumericalChecker() {
    return numericalChecker;
  }
}
