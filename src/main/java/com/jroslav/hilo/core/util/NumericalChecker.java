package com.jroslav.hilo.core.util;

import com.jroslav.hilo.core.localization.Localization;

public class NumericalChecker {

  public String getMessagesFromEnteredNumber(int guessNumber, int hiddenNumber) {

    final String resultCheck =
        (guessNumber < hiddenNumber)
            ? "hilo.process.low_message"
            : (guessNumber > hiddenNumber)
                ? "hilo.process.high_message"
                : "hilo.process.win_message";
    return Localization.getMessage(resultCheck).formatted(guessNumber);
  }
}
