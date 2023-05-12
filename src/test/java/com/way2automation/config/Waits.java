package com.way2automation.config;

import org.openqa.selenium.support.ui.WebDriverWait;

import static com.way2automation.config.BasePage.driver;

/**
 * Waits class
 */

public class Waits {
    public WebDriverWait wait;

    public WebDriverWait getWait() {
        return wait = new WebDriverWait(driver,5);
    }
}
