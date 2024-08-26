package com.jroslav.hilo;

import com.jroslav.hilo.core.config.Config;
import com.jroslav.hilo.ui.GameInterface;
import com.jroslav.hilo.ui.InterfaceFactory;
/**
 * @author Jroslav Trofimov
 * @version 0.0.1
 */
public class HiLoGame {

  public static void main(String[] args) {

    GameInterface gameInterface =
        InterfaceFactory.createGameInterface(Config.get("hilo.interface", "console"));
    gameInterface.start();
  }
}
