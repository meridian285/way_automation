package com.way2automation.tests;

import com.way2automation.dataProvider.RegistrationFormDataProvider;
import com.way2automation.help.JSExecutor;
import com.way2automation.listener.TestListener;
import com.way2automation.pages.DummyRegistrationPage;
import com.way2automation.pages.MainPage;
import io.qameta.allure.*;
import org.openqa.selenium.Dimension;
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
            dataProvider = "registrationFormDataProvider", dataProviderClass = RegistrationFormDataProvider.class, threadPoolSize = 4)
    public void checkRegistrationForm(String name, String phone, String email, String country, String city, String userName,
                                      String password, boolean check) {
        MainPage mainPage = new MainPage();
        DummyRegistrationPage dummyRegistrationPage = new DummyRegistrationPage();
        mainPage.clickMenu("Resources")
                .clickMenu("Practice Site 1");
        dummyRegistrationPage.signUpRegistrationForm(name, phone, email, country, city, userName, password)
                .checkMessagePresent(check);
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Story(value = "Some story")
    @Test(description = "Тест на проверку скролбаров, размер окна 500Х900")
    public void testScroll(){
        new MainPage();
        driver.manage().window().setSize(new Dimension(500, 900));
        Assert.assertTrue(new JSExecutor(driver).testVertScrollStatus(), "Проверка на вертикальную полосу прокрутки");
        Assert.assertTrue(new JSExecutor(driver).testHorizonScrollStatus(), "Проверка на горизонтальную полосу прокрутки");
    }
}
