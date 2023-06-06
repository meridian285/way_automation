package com.way2automation.tests;

import com.way2automation.help.Cookies;
import com.way2automation.pages.MainSQLPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  Тестовый класс LoginTests, тесты авторизации используя cookie от первой авторизации
 */

@Epic(value = "Тесты сайта https://www.sql-ex.ru/, с использованием куков")
@Feature(value = "Авторизация с использованием куков")
public class LoginTests extends BaseTest {

    @Test(description = "Авторизация на сайте", priority = 1)
    public void checkLoginValidData() throws IOException {
        new MainSQLPage().login("Aleksandr285", "7FdRTcgLv32-KNm");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.sql-ex.ru/index.php",
                "Ожидалась совпадение URL после авторизации");
        new Cookies(driver).setCookieToFile();
    }

    @Test(description = "Авторизация на сайте с помощью куков", priority = 2)
    public void checkTestAuthorisationWithCookie() throws FileNotFoundException {
        MainSQLPage mainSQLPage = new MainSQLPage();
        mainSQLPage.setCookie("PHPSESSID");
        Assert.assertTrue(mainSQLPage.checkButtonExit().isDisplayed(),
                "Ожидалось появление нужного элемента на экране");
    }
}