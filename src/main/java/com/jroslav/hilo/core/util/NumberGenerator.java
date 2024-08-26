package com.jroslav.hilo.core.util;

import java.security.SecureRandom;

public class NumberGenerator {

  private int minNumber, maxNumber;

  public NumberGenerator(int minNumber, int maxNumber) {
    this.minNumber = minNumber;
    this.maxNumber = maxNumber;
  }

  public int generate() {
    return new SecureRandom().nextInt(minNumber, maxNumber);
  }
}
