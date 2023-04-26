package com.way2automation.tests;

import com.way2automation.config.BaseTest;
import com.way2automation.pages.DummyRegistrationForm;
import com.way2automation.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void checkLogIn() {
        DummyRegistrationForm dummyRegistrationForm = new DummyRegistrationForm();
        MainPage mainPage = new MainPage();
        mainPage.clickResourcesMenu()
                .clickPracticeSite1Menu()
                .singInRegistrationForm("Vasya","35345345","werfgd@gmail.com","Russian Federation"
                        ,"Moscow", "Vasya","Vasya2342");
        Assert.assertEquals(dummyRegistrationForm.checkAlert()
                ,"This is just a dummy form, you just clicked SUBMIT BUTTON","Ожидалось совпадение сообщений");
    }
}
