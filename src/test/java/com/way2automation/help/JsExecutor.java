package com.way2automation.help;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *  Class JavascriptExecutor
 */

public class JsExecutor {
    protected WebDriver driver;
    JavascriptExecutor js;

    public JsExecutor(WebDriver webDriver){
        driver = webDriver;
        js = (JavascriptExecutor) driver;
    }

    @Step("Скролить до элемента")
    public void jsMoveToElement(WebElement webElement) {
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    @Step("Снять фокус с элемента")
    public void jsExecutorBlur(WebElement webElement) {
        js.executeScript("arguments[0].dispatchEvent(new Event('blur'))", webElement);
    }

    @Step("Проверить на наличие горизонтальной полосы прокрутки")
    public boolean isHorizonScrollStatus() {
        return (Boolean) js.executeScript(
                "return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
    }

    @Step("Проверить на наличие вертикальной полосы прокрутки")
    public boolean isVertScrollStatus() {
        return (Boolean) js.executeScript(
                "return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
    }
}
