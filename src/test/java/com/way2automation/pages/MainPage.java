package com.way2automation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Page class Main
 */

public class MainPage extends BasePage {

    // Локатор списка пунктов меню
    @FindBy(xpath = "//div[@id='ast-desktop-header']//span[@class='menu-text']")
    private List<WebElement> menuList;

    public MainPage() {
        driver.get("https://www.way2automation.com/");
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать на пункт меню")
    public MainPage clickMenu(String nameMenu) {
        menuList.stream().filter(x -> x.getText().equals(nameMenu)).findFirst().ifPresent(x -> x.click());
        return this;
    }
}
