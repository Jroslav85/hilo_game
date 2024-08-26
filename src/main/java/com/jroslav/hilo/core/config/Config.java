package com.jroslav.hilo.core.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
  private static Dotenv dotenv = Dotenv.load();

  public static String get(String key) {
    return dotenv.get(key);
  }

  /**
   * @param key Ключ переменной окружения, значение которой вы хотите получить.
   * @param defaultValue Значение по умолчанию, которое будет возвращено, если переменная окружения
   *     с указанным ключом не найдена.
   */
  public static String get(String key, String defaultValue) {
    return dotenv.get(key, defaultValue);
  }
}
