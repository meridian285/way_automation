package com.way2automation.pages;


import com.way2automation.help.Cookies;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

/**
 *  Page класс для тестов авторизации через Cookie
 */

public class MainSQLPage extends BasePage {
    // Локатор поля login
    @FindBy(xpath = "//form[@name='frmlogin']//input[@name='login']")
    private WebElement loginField;
    //Локатор поля password
    @FindBy(xpath = "//form[@name='frmlogin']//input[@name='psw']")
    private WebElement passwordField;
    // Локатор кнопки Enter
    @FindBy(xpath = "//form[@name='frmlogin']//input[@name='subm1']")
    private WebElement enterButton;
    // Локатор кнопки выхода
    @FindBy(xpath = "//a[@href='/logout.php']")
    private WebElement exitButton;

    public MainSQLPage() {
        driver.get("https://www.sql-ex.ru/");
        PageFactory.initElements(driver, this);
    }

    @Step("Авторизоваться")
    public void login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        enterButton.click();
    }

    @Step("Вернуть веб элемент кнопки выхода")
    public WebElement checkButtonExit() {
        return exitButton;
    }

    @Step()
    public void setCookie(String nameCookie) throws FileNotFoundException {
        driver.manage().addCookie(new Cookies(driver).getCookieFromFile(nameCookie));
        driver.navigate().refresh();
    }
}


