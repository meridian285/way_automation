package com.way2automation.tests;

import com.way2automation.config.BaseTest;
import com.way2automation.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void checkLogIn() {
        MainPage mainPage = new MainPage();
        mainPage.clickMemberLoginMenu()
                .clickCheckBox()
                .clickLoginLink()
                .singIn("testik285555@gmail.com","Test!k123");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.selenium-tutorial.com/",
                "Ожидаемая страница отличается от загруженой");
    }
}
