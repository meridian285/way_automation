package com.way2automation.tests;

import com.way2automation.config.BaseTest;
import com.way2automation.dataProvider.RegistrationFormDataProvider;
import com.way2automation.listener.TestListener;
import com.way2automation.pages.DummyRegistrationPage;
import com.way2automation.pages.MainPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Тестовый класс DummyRegistrationFormTests
 */
@Epic(value = "Заполнение формы")
@Feature(value = "Регистрация пользователя")
@Listeners(TestListener.class)
public class DummyRegistrationFormTests extends BaseTest {

    @Severity(value = SeverityLevel.CRITICAL)
    @Story(value = "Some story")
    @Test(description = "Параметризованный тест проверки формы регистрации",
            dataProvider = "registrationFormDataProvider", dataProviderClass = RegistrationFormDataProvider.class)
    public void checkRegistrationForm(String name, String phone, String email, String country, String city, String userName
            , String password, boolean check) {
        MainPage mainPage = new MainPage();
        DummyRegistrationPage dummyRegistrationPage = new DummyRegistrationPage();
        mainPage.clickMenu("Resources")
                .clickMenu("Practice Site 1");
        dummyRegistrationPage.signUpRegistrationForm(name, phone, email, country, city, userName, password);
        Assert.assertEquals(dummyRegistrationPage.checkAlertText(), check, "Проверка появилось ли сообщение");
        // Проверка на корректность сообщения
        dummyRegistrationPage.checkMessage();
    }
}
