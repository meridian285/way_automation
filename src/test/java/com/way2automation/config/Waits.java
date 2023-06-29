package com.way2automation.config;

import com.way2automation.pages.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Waits class
 */

public class Waits extends BasePage {

    protected WebDriverWait wait;

    public Waits(WebDriver webDriver) {
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
    }

    // Ожидание видимости элемента
    public WebElement untilVisible(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Ожидание видимости элемента содержащего текст
     *
     * @param webElement
     * @param message
     * @return
     */
    public boolean untilTextToBePresentInElement(WebElement webElement, String message) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, message));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement untilElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
