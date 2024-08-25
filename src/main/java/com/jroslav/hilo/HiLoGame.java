package com.jroslav.hilo;

import com.jroslav.hilo.service.config.Config;
import com.jroslav.hilo.ui.console.ConsoleGameApp;

// import com.jroslav.hilo.gui.HiloFrame;

public class HiLoGame {

  public static void main(String[] args) {

    final int min = Integer.parseInt(Config.get("min"));
    final int max = Integer.parseInt(Config.get("max"));
    final ConsoleGameApp app = new ConsoleGameApp(min, max);

    app.start();
    //    new HiloFrame();

  }
}
