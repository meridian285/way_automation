package com.way2automation.help;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.nio.file.Path;

/**
 * Интерфейс для чтения из файла properties
 */
public interface ReadProperties {

    static Config readProperty() {
        return ConfigFactory.load("application.properties");
    }

    String LOGIN = readProperty().getString("user.login");
    String PASSWORD = readProperty().getString("user.password");
    String COOKIE_PATH = readProperty().getString("cookie.cookiePath");
    String PHPSESSID_REGEXP = readProperty().getString("cookiePhpsessid.regexp");
    String PHPSESSID_NAME = readProperty().getString("cookie.phpsessid");
}
