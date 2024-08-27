package com.jroslav.hilo.ui.gui;

import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ButtonReset extends JButton {
  @Autowired
  public ButtonReset() {
    this.setText(" reset game ");
  }
}
