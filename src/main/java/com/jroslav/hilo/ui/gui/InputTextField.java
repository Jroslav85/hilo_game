package com.jroslav.hilo.ui.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InputTextField extends JTextField {

  @Autowired
  public InputTextField() {
    this.setColumns(25);
    
    this.addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
              e.consume(); // Игнорировать ввод символов, которые не являются цифрами
            }
          }
        });
  }
}
