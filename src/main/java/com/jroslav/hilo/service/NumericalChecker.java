package com.jroslav.hilo.service;

import com.jroslav.hilo.service.localization.Localization;

public class NumericalChecker extends Localization {

  public String getMessagesFromEnteredNumber(int guessNumber, int hiddenNumber) {

    final String resultCheck;
    if (guessNumber < hiddenNumber) {
      resultCheck = messages.getString("TOO_LOW").formatted(guessNumber);
    } else if (guessNumber > hiddenNumber) {
      resultCheck = messages.getString("TOO_HIGH").formatted(guessNumber);
    } else {
      resultCheck = messages.getString("YOU_WIN").formatted(guessNumber);
    }
    return resultCheck;
  }
}
