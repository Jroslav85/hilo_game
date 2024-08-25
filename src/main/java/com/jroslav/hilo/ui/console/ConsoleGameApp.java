package com.jroslav.hilo.ui.console;

import java.util.Scanner;

import com.jroslav.hilo.service.GameContext;
import com.jroslav.hilo.service.exception.NonNumericInputException;
import com.jroslav.hilo.service.exception.NumberOutOfRangeException;
import com.jroslav.hilo.service.localization.Localization;

public class ConsoleGameApp {
  private final int min;
  private final int max;
  private final GameContext context;

  public ConsoleGameApp(int min, int max) {
    this.min = min;
    this.max = max;
    context = new GameContext(min, max);
  }

  public void start() {
    try (Scanner console = new Scanner(System.in)) {
      String guessString = "";
      int guess = 0;
      String playAgain = "";
      int tries = 0;

      do {
        int number = context.getHiddenNumber();
        tries = 0;
        printWelcomeMessage();
        boolean validInput = false;

        do {
          do {
            try {
              guessString = console.nextLine();
              guess = context.getInputHandler().parseString(guessString.trim());
              validInput = true;
              tries++;
            } catch (NonNumericInputException | NumberOutOfRangeException e) {
              System.out.println(e.getMessage());
            }
          } while (!validInput);

          System.out.print(
              context.getNumericalChecker().getMessagesFromEnteredNumber(guess, number));
        } while (guess != number);

        printCongratulations(tries);
        System.out.print(Localization.getMessage("PLAY_AGAIN"));
        playAgain = console.next();
        console.nextLine();
      } while ("y".equalsIgnoreCase(playAgain));
      System.out.print(Localization.getMessage("GOODBYE"));
    }
  }

  private void printWelcomeMessage() {
    System.out.print(Localization.getMessage("TASK").formatted(min, max));
  }

  private void printCongratulations(int tries) {
    System.out.print(Localization.getMessage("YOU_TRIES").formatted(tries));
  }
}
