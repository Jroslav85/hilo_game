package com.jroslav.hilo.ui.gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jroslav.hilo.core.config.Config;
import com.jroslav.hilo.core.localization.Localization;

@Configuration
@ComponentScan(basePackages = "com.jroslav")
public class AppConfig {
  private int min = Integer.parseInt(Config.get("min", "1"));
  private int max = Integer.parseInt(Config.get("max", "100"));

  private String title = Localization.getMessage("hilo.title");
  private String task = Localization.getMessage("hilo.process.task").formatted(min, max);

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  @Bean
  public MainFrame mainFrame() {
    return new MainFrame(title, mainPanel());
  }

  @Bean
  public MainPanel mainPanel() {
    return new MainPanel(listLabels(), listButtons(), listFields());
  }

  @Bean
  public List<JLabel> listLabels() {
    return Arrays.asList(labelTask(), labelProgressGame());
  }

  @Bean
  public List<JButton> listButtons() {
    return Arrays.asList(buttonAcceptingAnswer(), buttonReset());
  }

  @Bean
  public LabelTask labelTask() {
    return new LabelTask(task);
  }

  @Bean
  public LabelProgressGame labelProgressGame() {
    return new LabelProgressGame();
  }

  @Bean
  public ButtonAcceptingAnswer buttonAcceptingAnswer() {
    return new ButtonAcceptingAnswer();
  }

  @Bean
  public InputTextField inputTextField() {
    return new InputTextField();
  }

  @Bean
  public List<JTextField> listFields() {
    return Arrays.asList(inputTextField());
  }

  @Bean
  public ButtonReset buttonReset() {
    return new ButtonReset();
  }
}
