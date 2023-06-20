package com.way2automation.pages;

import com.way2automation.help.JsExecutor;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    @Step("Изменить размер окна браузера")
    public MainPage changeWindowSize(){
        driver.manage().window().setSize(new Dimension(500, 900));
        return this;
    }

    @Step("Проверить что есть вертикальная полоса прокрутки")
    public void checkVertScroll(){
        Assert.assertTrue(new JsExecutor(driver).isVertScrollStatus(), "Проверка на вертикальную полосу прокрутки");
    }

    @Step("Проверить что есть горизонтальная полоса прокрутки")
    public void checkHorizonScroll(){
        Assert.assertTrue(new JsExecutor(driver).isHorizonScrollStatus(), "Проверка на горизонтальную полосу прокрутки");
    }
}
