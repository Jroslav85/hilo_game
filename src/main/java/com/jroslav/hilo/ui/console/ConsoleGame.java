package com.jroslav.hilo.ui.console;

import java.util.Scanner;

import com.jroslav.hilo.core.GameContext;
import com.jroslav.hilo.core.config.Config;
import com.jroslav.hilo.core.localization.Localization;
import com.jroslav.hilo.ui.GameInterface;

public class ConsoleGame implements GameInterface {
  private final int min;
  private final int max;
  private final GameContext context;
  private boolean isWin = false;
  private boolean isExit = false;
  private int tries = 0;

  public ConsoleGame() {
    min = Integer.parseInt(Config.get("min"));
    max = Integer.parseInt(Config.get("max"));
    context = new GameContext(min, max);
  }

  public void start() {
    try (Scanner console = new Scanner(System.in)) {

      while (!isExit) {
        printWelcomeMessage();
        int hiddenNumber = context.getHiddenNumber();

        while (!isWin) {
          String guessString = console.nextLine();
          int guess = getCorrectNumber(guessString);
          String message = getMessageAfterComparison(guess, hiddenNumber);
          printSelectionResult(message);
          if (guess == hiddenNumber) {
            isWin = true;
          }
        }
        printCongratulations(tries);
        printOfferToPlay();
        if (!console.nextLine().equalsIgnoreCase("y")) {
          isExit = true;
        }

        initNewGame();
      }
      printFarewellToUser();
    }
  }

  private void printWelcomeMessage() {
    System.out.println(Localization.getMessage("hilo.process.task").formatted(min, max));
  }

  private void printSelectionResult(String message) {
    System.out.print(message + "\n");
  }

  private void printOfferToPlay() {
    System.out.println(Localization.getMessage("hilo.process.play_again_message"));
  }

  private String getMessageAfterComparison(int guess, int hiddenNumber) {
    tries++;
    return context.getNumericalChecker().getMessagesFromEnteredNumber(guess, hiddenNumber);
  }

  private void initNewGame() {
    tries = 0;
    isWin = false;
  }

  private int getCorrectNumber(String guessString) {
    int guess = 0;
    try {
      context.getInputValidator().validate(guessString);
      guess = context.getInputParser().parseString(guessString);
      context.getRangeValidator().validate(guess);
    } catch (RuntimeException e) {
      printException(e);
    }
    return guess;
  }

  private void printException(RuntimeException e) {
    System.out.println(e.getMessage());
  }

  private void printCongratulations(int tries) {
    System.out.println(Localization.getMessage("hilo.process.tries_message").formatted(tries));
  }

  private void printFarewellToUser() {
    System.out.println(Localization.getMessage("hilo.process.goodbye_message"));
  }
}
