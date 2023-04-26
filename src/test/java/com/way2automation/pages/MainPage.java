package com.way2automation.pages;

import com.way2automation.config.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class Main
 */

public class MainPage extends BasePage {
    //Локатор пункта меню ManagerLoginButton
    @FindBy(id = "menu-item-27625")
    private WebElement bankManagerLoginButton;

    public MainPage(){
        driver.get("https://www.way2automation.com/");
        PageFactory.initElements(driver, this);
    }

    public SecurityPage clickMemberLoginMenu() {
        bankManagerLoginButton.click();
        return new SecurityPage();
    }
}
