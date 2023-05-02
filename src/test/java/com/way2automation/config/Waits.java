package com.way2automation.config;

import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Waits class
 */

public class Waits extends BasePage{
    private WebDriverWait wait ;

    public WebDriverWait getWait() {
        return wait = new WebDriverWait(driver,5);
    }
}
