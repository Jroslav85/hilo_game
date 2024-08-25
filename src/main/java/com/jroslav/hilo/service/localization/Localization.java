package com.jroslav.hilo.service.localization;

import java.util.Locale;
import java.util.ResourceBundle;

import com.jroslav.hilo.service.config.Config;

public class Localization {
  protected static ResourceBundle resourceBundle;
  private Locale appLocale;

  public Localization() {
    String locale = Config.get("HILO_LOCALE", "en");
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
