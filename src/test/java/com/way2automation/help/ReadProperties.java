package com.way2automation.help;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Интерфейс для чтения из файла properties
 */
public interface ReadProperties {

    static Config readProperty() {
        return ConfigFactory.load("application.properties");
    }

     int MAX_COUNT = readProperty().getInt("maxCount");
}
