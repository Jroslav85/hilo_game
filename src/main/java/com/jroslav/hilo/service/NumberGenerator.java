package com.jroslav.hilo.service;

import java.util.Random;
import java.security.SecureRandom;

public class NumberGenerator {

  private final int minNumber;
  private final int maxNumber;
  private final Random random;

  public NumberGenerator(int minNumber, int maxNumber) {
    this.minNumber = minNumber;
    this.maxNumber = maxNumber;
    random = new SecureRandom();
  }

  public int getGenerateNumber() {
    return random.nextInt(minNumber, maxNumber);
  }
}
