package com.way2automation.pages;

import com.way2automation.config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Page class Main
 */

public class MainPage extends BasePage {

    public MainPage(){
        driver.get("https://www.way2automation.com/");
        PageFactory.initElements(driver, this);
    }
    // Метод получения локатора
    public WebElement menu(String nameMenu){
        return driver.findElement(By.xpath(
                   "//div[@id='ast-desktop-header']//span[@class='menu-text' and contains(./text(), '"+nameMenu+"')]"));
    }
    // Метод клика по пункту меню
    public void clickMenu(String nameMenu) {
        menu(nameMenu).click();
    }
}
