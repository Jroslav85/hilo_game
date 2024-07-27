package com.jroslav.hilo.core;

import java.util.Random;
import java.security.SecureRandom;

public class RandomNumber {

  private final int minNumber;
  private final int maxNumber;
  private final Random random;

  public RandomNumber(int minNumber, int maxNumber) {
    this.minNumber = minNumber;
    this.maxNumber = maxNumber;
    random = new SecureRandom();
  }

  public int getGenerateNumber() {
    return random.nextInt(minNumber, maxNumber);
  }
}
