package com.way2automation.help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс SwitchTo
 */
public class SwitchTo {
    private static WebDriver driver;

    public SwitchTo(WebDriver webDriver) {
        driver = webDriver;
    }

    public void switchToFrame(WebElement webElement) {
        driver.switchTo().frame(webElement);
    }

    // Переключиться на вкладку браузера
    public WebDriver switchToTabs(int index) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        return driver.switchTo().window(windowHandles.get(index));
    }

    /**
     * Вложенный класс для отделения Alert
     */
    public static class Alert {
        public void inputAlertValues(String value) {
            driver.switchTo().alert().sendKeys(value);
        }

        public void alertAccept() {
            driver.switchTo().alert().accept();
        }
    }
}
