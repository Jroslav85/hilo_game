package com.jroslav.hilo.ui.gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel {
  private int x, y;
  private String text;
  

  public Label(int x, int y, String text) {
    this.y = y;
    this.text = text;
    setLocation(x, y);
    setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
    setText(text);
    this.setSize(
        new Dimension(
            this.getFontMetrics(this.getFont()).stringWidth(text) + 5,
            this.getFontMetrics(this.getFont()).getHeight() + 5));
  }
}
