package com.jroslav.hilo.ui.gui;

import java.awt.Font;

import javax.swing.JLabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LabelTask extends JLabel {

  @Autowired
  public LabelTask(String text) {
    this.setText(text);
    this.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
    this.setSize(100, 10);
  }
}
