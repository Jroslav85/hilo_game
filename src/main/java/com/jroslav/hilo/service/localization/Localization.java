package com.jroslav.hilo.service.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {
  private Locale currentLocale;
  protected ResourceBundle messages;

  public Localization() {
    currentLocale = new Locale("en"); // Измените на "en" для английского
    messages = ResourceBundle.getBundle("messages", currentLocale);
  }
}
