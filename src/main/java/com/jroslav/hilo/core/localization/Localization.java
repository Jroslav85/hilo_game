package com.jroslav.hilo.core.localization;

import java.util.Locale;
import java.util.ResourceBundle;

import com.jroslav.hilo.core.config.Config;

public class Localization {
  protected static ResourceBundle resourceBundle;
  private Locale appLocale;

  static {
    new Localization();
  }

  public Localization() {
    String locale = Config.get("hilo.locale", "en");

    if (locale != null) {
      appLocale = new Locale(locale);
      Locale.setDefault(appLocale);
    }
    resourceBundle = ResourceBundle.getBundle("messages", appLocale);
  }

  public static String getMessage(String message) {
    return resourceBundle.getString(message);
  }
}
