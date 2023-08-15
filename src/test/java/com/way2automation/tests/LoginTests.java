package com.way2automation.tests;

import com.way2automation.pages.MainSQLPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Тестовый класс LoginTests, тесты авторизации используя cookie от первой авторизации
 */

@Epic(value = "Тесты сайта https://www.sql-ex.ru/, с использованием куков")
@Feature(value = "Авторизация с использованием куков")
public class LoginTests extends BaseTest {

    @BeforeMethod
    public void setUpCookie() {
        new MainSQLPage().createCookieFile();
    }

    @Test(description = "Авторизация на сайте с помощью куков")
    public void checkTestAuthorisationWithCookie() {
        new MainSQLPage().checkAuthorization();
    }
}
