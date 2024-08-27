package com.jroslav.hilo.ui.gui;

import java.awt.Font;

import javax.swing.JLabel;

import org.springframework.stereotype.Component;

@Component
public class LabelProgressGame extends JLabel {

  public LabelProgressGame() {
    this.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
    this.setSize(100, 10);
  }
}
