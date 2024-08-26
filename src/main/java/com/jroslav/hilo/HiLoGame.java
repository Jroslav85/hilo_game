package com.jroslav.hilo;

import com.jroslav.hilo.core.config.Config;
import com.jroslav.hilo.ui.console.ConsoleGame;

// import com.jroslav.hilo.gui.HiloFrame;

public class HiLoGame {

  public static void main(String[] args) {

    final int min = Integer.parseInt(Config.get("min"));
    final int max = Integer.parseInt(Config.get("max"));
    final ConsoleGame app = new ConsoleGame(min, max);

    app.start();
    //    new HiloFrame();

  }
}
