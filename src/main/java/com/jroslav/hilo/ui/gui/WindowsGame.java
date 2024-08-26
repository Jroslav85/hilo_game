package com.jroslav.hilo.ui.gui;

import javax.swing.SwingUtilities;

import com.jroslav.hilo.core.config.Config;
import com.jroslav.hilo.core.localization.Localization;
import com.jroslav.hilo.ui.GameInterface;

public class WindowsGame implements GameInterface {
  private String title = Localization.getMessage("hilo.title");

  @Override
  public void start() {
    SwingUtilities.invokeLater(
        () -> {
          MainFrame frame = new MainFrame(title);
          frame.setVisible(true);
        });
  }
  
  
}
