package com.jroslav.hilo.core;

import com.jroslav.hilo.core.validate.InputHandler;
import com.jroslav.hilo.core.validate.NonNumericInputValidator;
import com.jroslav.hilo.core.validate.NumberOutOfRangeValidator;

public class GameContext {
  private InputHandler inputHandler;
  private NonNumericInputValidator inputValidator;
  private RandomNumber randomNumber;
  private NumericalChecker numericalChecker;
  private NumberOutOfRangeValidator rangeValidator;

  public GameContext(int minNumber, int maxNumber) {
    randomNumber = new RandomNumber(minNumber, maxNumber);
    inputValidator = new NonNumericInputValidator();
    rangeValidator = new NumberOutOfRangeValidator(minNumber, maxNumber);
    inputHandler = new InputHandler(inputValidator, rangeValidator);
    numericalChecker = new NumericalChecker();
  }

  public InputHandler getInputHandler() {
    return inputHandler;
  }

  public RandomNumber getRandomNumber() {
    return randomNumber;
  }

  public NumericalChecker getNumericalChecker() {
    return numericalChecker;
  }
}
