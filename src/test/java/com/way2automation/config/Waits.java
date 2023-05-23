package com.way2automation.config;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Waits class
 */

public class Waits {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public Waits(WebDriver webDriver){
        driver = webDriver;
    }

    public WebElement untilVisible(WebElement webElement) {
        wait = new WebDriverWait(driver, 3);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    // Не нашел варианта как сделать проверку без try, задание сделать универсальную проверку, для этого нужно
    // обрабатывать оба варианта
    // если бы не нужен был wait то все ок было бы, без try. Но т.к. элемент появляется не сразу, то я не придумал как...
    // и еще загвоздка что элемент уже есть в дереве, только без текста
    public boolean untilTextToBePresentInElement(WebElement webElement, String message) {
        wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, message));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
