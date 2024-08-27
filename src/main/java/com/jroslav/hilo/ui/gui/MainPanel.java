package com.jroslav.hilo.ui.gui;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainPanel extends JPanel {

  @Autowired
  public MainPanel(
      List<JLabel> listLabels, List<JButton> listButtons, List<JTextField> listFields) {

    addComponents(listLabels);
    addComponents(listFields);
    addComponents(listButtons);

    this.setLayout(new FlowLayout());
  }

  private void addComponents(List<? extends java.awt.Component> components) {
    for (java.awt.Component component : components) {
      this.add(component);
    }
  }
}
