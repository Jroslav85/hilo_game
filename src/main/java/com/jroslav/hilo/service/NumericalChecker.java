package com.jroslav.hilo.service;

import com.jroslav.hilo.service.localization.Localization;

public class NumericalChecker {

  public String getMessagesFromEnteredNumber(int guessNumber, int hiddenNumber) {

    final String resultCheck =
        (guessNumber < hiddenNumber)
            ? "TOO_LOW"
            : (guessNumber > hiddenNumber) ? "TOO_HIGH" : "YOU_WIN";
    return Localization.getMessage(resultCheck).formatted(guessNumber);
  }
}
