package com.way2automation.pages;

import com.way2automation.config.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class Main
 */

public class MainPage extends BasePage {

    //Локатор пункта меню Resources
    @FindBy(id = "menu-item-27617")
    private WebElement resourcesMenu;
    //Локатор пункта подменю Practice Site 1
    @FindBy(id = "menu-item-27618")
    private WebElement practiceSite1Menu;

    public MainPage(){
        driver.get("https://www.way2automation.com/");
        PageFactory.initElements(driver, this);
    }

    public MainPage clickResourcesMenu() {
        resourcesMenu.click();
        return this;
    }

    public DummyRegistrationPage clickPracticeSite1Menu(){
        practiceSite1Menu.click();
        return new DummyRegistrationPage();
    }
}
