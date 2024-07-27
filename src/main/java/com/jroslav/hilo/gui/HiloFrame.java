package com.jroslav.hilo.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.jroslav.hilo.core.GameContext;
import com.jroslav.hilo.core.exception.NonNumericInputException;
import com.jroslav.hilo.core.exception.NumberOutOfRangeException;
import com.jroslav.hilo.core.localization.Localization;

public class HiloFrame extends Localization {
  private final JFrame frame;
  private GameContext context;
  private final int MIN = 1;
  private final int MAX = 10;
  private final JTextField fieldGuess;
  private final JLabel labelTask;
  private JLabel labelOutput;
  private int number;
  private int guess;

  public HiloFrame() {
    context = new GameContext(MIN, MAX);

    frame = new JFrame(messages.getString("TITLE_APP"));
    frame.setDefaultCloseOperation(3);
    frame.setLocation(500, 400);
    frame.setSize(400, 300);
    frame.getContentPane().setLayout(null);
    frame.setResizable(false);
    labelTask = new JLabel(messages.getString("TASK").formatted(MIN, MAX));
    labelTask.setHorizontalAlignment(SwingConstants.RIGHT);
    labelTask.setBounds(20, 45, 200, 16);
    frame.getContentPane().add(labelTask);

    fieldGuess = new JTextField();
    fieldGuess.setHorizontalAlignment(SwingConstants.CENTER);
    fieldGuess.setBounds(230, 45, 50, 16);
    fieldGuess.setBorder(BorderFactory.createEtchedBorder(1));
    frame.getContentPane().add(fieldGuess);

    fieldGuess.setColumns(10);
    fieldGuess.addActionListener(e -> checkGuess());
    JButton guessButton = new JButton("Guess !");
    guessButton.setBounds(131, 141, 149, 23);
    frame.getContentPane().add(guessButton);

    guessButton.addActionListener(e -> checkGuess());
    labelOutput = new JLabel("");
    labelOutput.setHorizontalAlignment(SwingConstants.CENTER);
    labelOutput.setBounds(10, 88, 364, 30);
    frame.getContentPane().add(labelOutput);

    JButton newGameButton = new JButton("New Game");
    newGameButton.setBounds(131, 175, 149, 23);
    newGameButton.addActionListener(e -> newGame());
    frame.getContentPane().add(newGameButton);
    frame.setVisible(true);
    newGame();
  }

  private void checkGuess() {
    int result = 0;
    try {
      result = context.getInputHandler().parseString(fieldGuess.getText());
      String answer = context.getNumericalChecker().getMessagesFromEnteredNumber(result, number);
      labelOutput.setText(answer);
      startNewGame(answer);

    } catch (NumberOutOfRangeException | NonNumericInputException e) {
      labelOutput.setText(e.getMessage());
    } finally {
      fieldGuess.requestFocus();
      fieldGuess.selectAll();
    }

  }

  private void newGame() {
    number = context.getRandomNumber().getGenerateNumber();
  }

  private void startNewGame(String input) {
    if (input.endsWith(messages.getString("YOU_WIN").substring(5))) {
      newGame();
    }
  }
}
