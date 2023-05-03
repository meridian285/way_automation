package com.way2automation.tests;

import com.way2automation.config.BaseTest;
import com.way2automation.pages.DummyRegistrationPage;
import com.way2automation.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Тестовый класс DummyRegistrationFormTests
 */
public class DummyRegistrationFormTests extends BaseTest {

    @Test
    public void checkRegistrationForm() {
        DummyRegistrationPage dummyRegistrationPage = new DummyRegistrationPage();
        MainPage mainPage = new MainPage();
        mainPage.clickMenu("Resources");
        mainPage.clickMenu("Practice Site 1");
        dummyRegistrationPage.signUpRegistrationForm(
                "Vasya",
                "35345345",
                "werfgd@gmail.com",
                "Russian Federation",
                "Moscow",
                "Vasya",
                "Vasya2342");
        Assert.assertEquals(dummyRegistrationPage.getAlertText(),
                "This is just a dummy form, you just clicked SUBMIT BUTTON","Ожидалось совпадение сообщений");
    }
}
