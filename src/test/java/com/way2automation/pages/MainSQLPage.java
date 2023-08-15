package com.way2automation.pages;


import com.way2automation.help.CookiesHelper;
import com.way2automation.help.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;

import static com.way2automation.help.FilesClass.isFileExists;

/**
 * Page класс для тестов авторизации через Cookie
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
    private WebElement logoutButton;

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

    @Step("Добавить нужные для авторизации куки")
    public void saveCookie(String nameCookie) {
        driver.manage().addCookie(new CookiesHelper(driver).getCookieFromFile(nameCookie));
        driver.navigate().refresh();
    }

    @Step("Проверить что авторизация прошла успешно")
    public void checkAuthorization() {
        Assert.assertTrue(logoutButton.isDisplayed(), "Ожидалось появление нужного элемента на экране");
    }

    @Step("Проверить есть ли файл с куками, если нет то создать")
    public void createCookieFile() {
        File file = new File(ReadProperties.COOKIE_PATH);
        if (isFileExists(file)) {
            saveCookie(ReadProperties.PHPSESSID_NAME);
        } else {
            login(ReadProperties.LOGIN, ReadProperties.PASSWORD);
            checkAuthorization();
            new CookiesHelper(driver).saveCookieToFile();
        }
    }
}

