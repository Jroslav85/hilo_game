package com.jroslav.hilo.ui.gui;

import javax.swing.SwingUtilities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jroslav.hilo.core.gamelogic.NumberGenerator;
import com.jroslav.hilo.core.gamelogic.NumericalChecker;
import com.jroslav.hilo.ui.GameInterface;

public class WindowsGame implements GameInterface {
  private NumberGenerator numberGenerator;
  private int hiddenNumber;
  private int tries;
  private String output;
  private NumericalChecker numericalChecker;

  @SuppressWarnings("resource")
  @Override
  public void start() {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    AppConfig appConfig = context.getBean(AppConfig.class);
    numberGenerator = new NumberGenerator(appConfig.getMin(), appConfig.getMax());

    SwingUtilities.invokeLater(
        () -> {
          MainFrame frame = context.getBean(MainFrame.class);
          frame.setVisible(true);
        });

    ButtonAcceptingAnswer buttonAcceptingAnswer = context.getBean(ButtonAcceptingAnswer.class);
    InputTextField inputTextField = context.getBean(InputTextField.class);
    LabelProgressGame labelProgressGame = context.getBean(LabelProgressGame.class);
    ButtonReset buttonReset = context.getBean(ButtonReset.class);
    numericalChecker = new NumericalChecker();
    newGame();
    checkNumber(buttonAcceptingAnswer, inputTextField, labelProgressGame);
    beginNewGame(buttonReset);
  }

  private void beginNewGame(ButtonReset buttonReset) {
    buttonReset.addActionListener(
        e -> {
          newGame();
          System.out.println(hiddenNumber);
        });
  }

  private void checkNumber(
      ButtonAcceptingAnswer buttonAcceptingAnswer,
      InputTextField inputTextField,
      LabelProgressGame labelProgressGame) {
    buttonAcceptingAnswer.addActionListener(
        e -> {
          output =
              numericalChecker.getMessagesFromEnteredNumber(
                  Integer.parseInt(inputTextField.getText()), hiddenNumber);
          labelProgressGame.setText(output);
          inputTextField.setText("");
          tries++;
        });
  }

  private void newGame() {
    hiddenNumber = numberGenerator.generate();
    tries = 0;
  }
}
