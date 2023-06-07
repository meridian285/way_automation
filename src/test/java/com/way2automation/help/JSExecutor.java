package com.way2automation.help;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *  Class JavascriptExecutor
 */

public class JSExecutor {
    protected WebDriver driver;

    public JSExecutor(WebDriver webDriver){
        driver = webDriver;
    }

    @Step("Скролить до элемента")
    public void jsMoveToElement(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    @Step("Снять фокус с элемента")
    public void jsExecutorBlur(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('blur'))", webElement);
    }

    @Step("Проверить на наличие горизонтальной полосы прокрутки")
    public boolean testHorizonScrollStatus() {
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
    }

    @Step("Проверка на наличие вертикальной полосы прокрутки")
    public boolean testVertScrollStatus() {
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
    }
}
