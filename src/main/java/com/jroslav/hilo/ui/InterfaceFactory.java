package com.jroslav.hilo.ui;

import com.jroslav.hilo.ui.console.ConsoleGame;
import com.jroslav.hilo.ui.gui.WindowsGame;

public class InterfaceFactory {

  public static GameInterface createGameInterface(String intefaceType) {
    switch (intefaceType) {
      case "console":
        return new ConsoleGame();
      case "windows":
        return new WindowsGame();
      default:
        return new ConsoleGame();
    }
  }
}
