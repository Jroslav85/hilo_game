package com.jroslav.hilo.ui.gui;

import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ButtonAcceptingAnswer extends JButton {

  @Autowired
  public ButtonAcceptingAnswer() {
    this.setText(" Accepting Answer ");
  }
}
