package com.jroslav.hilo;

import com.jroslav.hilo.ui.console.ConsoleGameApp;

import io.github.cdimascio.dotenv.Dotenv;

// import com.jroslav.hilo.gui.HiloFrame;

public class HiLoGame {

  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.load();
    int min = Integer.parseInt(dotenv.get("min"));
    int max = Integer.parseInt(dotenv.get("max"));
    final ConsoleGameApp app = new ConsoleGameApp(min, max);
    
    app.start();
    //    new HiloFrame();
  }
}
