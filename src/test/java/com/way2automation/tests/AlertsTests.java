package com.way2automation.tests;

import com.way2automation.help.SwitchTo;
import com.way2automation.pages.InputAlertPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Тестовый класс для проверки Alerts
 */

public class AlertsTests extends BaseTest {

    @Test(description = "Тест на ввод текста в алерт окне")
    public void checkAlertInputBox() {
        InputAlertPage inputAlertPage = new InputAlertPage();
        inputAlertPage.clickInputAlertMenu()
                .clickAlertInputBoxButton();
        new SwitchTo(driver).inputAlertValues("Vasya Pupkin");
        new SwitchTo(driver).alertAccept();
        Assert.assertTrue(inputAlertPage.getTextField().contains("Vasya Pupkin"));
    }
}
