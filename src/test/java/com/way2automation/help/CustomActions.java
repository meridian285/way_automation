package com.way2automation.help;

import com.way2automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Класс для Actions
 */

public class CustomActions extends BasePage {

    private final Actions actions;

    public CustomActions(WebDriver webDriver) {
        actions = new Actions(webDriver);
    }

    public void buildDragAndDrop(WebElement firstElement, WebElement secondElement) {
        actions.moveToElement(firstElement)
                .clickAndHold()
                .moveToElement(secondElement)
                .release().build().perform();
    }
}
