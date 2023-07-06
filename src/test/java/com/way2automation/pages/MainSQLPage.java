package com.way2automation.pages;


import com.way2automation.help.Cookies;
import com.way2automation.help.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.way2automation.help.FilesClass.isFileExists;

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
    public WebElement buttonExit() {
        return exitButton;
    }

    @Step("Добавить нужные для авторизации куки")
    public void saveCookie(String nameCookie) {
        try {
            driver.manage().addCookie(new Cookies(driver).getCookieFromFile(nameCookie));
            driver.navigate().refresh();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Проверить что авторизация прошла успешно")
    public void checkVisibleLogInButton(){
        Assert.assertTrue(buttonExit().isDisplayed(), "Ожидалось появление нужного элемента на экране");
    }

    @Step("Проверить есть ли файл с куками, если нет то создать")
    public void authorizationWithLoginPassword(){
        File file = new File("src/test/resources/cookies.txt");
        if (isFileExists(file)) {
                saveCookie("PHPSESSID");
        } else {
                login(ReadProperties.LOGIN, ReadProperties.PASSWORD);
                checkVisibleLogInButton();
                new Cookies(driver).saveCookieToFile();
        }
    }
}

