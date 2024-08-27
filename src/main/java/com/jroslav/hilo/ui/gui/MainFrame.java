package com.jroslav.hilo.ui.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainFrame extends JFrame {

  @Autowired
  public MainFrame(String title, JPanel panel) {
    this.setTitle(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(350, 180);
    this.setLocationRelativeTo(null);
    this.add(panel);
  }
}
