package com.jroslav.hilo.ui.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jroslav.hilo.core.config.Config;
import com.jroslav.hilo.core.localization.Localization;

public class MainFrame extends JFrame {
  private int min = Integer.parseInt(Config.get("min"));
  private int max = Integer.parseInt(Config.get("max"));

  private Label labelTask;
  private Label labelChoiseResul;

  public MainFrame(String title) {
    setTitle(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 200);
    setLocationRelativeTo(null);
    setResizable(false);
    setLayout(null);

    String taskText = Localization.getMessage("hilo.process.task").formatted(min, max);
    labelTask = new Label(10, 10, taskText);
    add(labelTask);

    String resultText = "текст проверки введенного числа";
    labelChoiseResul = new Label(50, labelTask.getHeight() + 10, resultText);
    add(labelChoiseResul);

    JTextField answerField = new JTextField(10);
    answerField.setLocation(100, (labelTask.getHeight() + 10) * 2);
    answerField.setSize(100, 24);
    add(answerField);
    answerField.addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c)) {
              e.consume(); // Игнорируем нечисловые символы
            }
          }
        });
  }
}
