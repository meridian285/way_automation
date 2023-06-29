package com.way2automation.tests;

import com.way2automation.pages.InputAlertPage;
import org.testng.annotations.Test;

/**
 * Тестовый класс для проверки Alerts
 */

public class AlertsTests extends BaseTest {

    @Test(description = "Тест на ввод текста в алерт окне")
    public void checkAlertInputBox() {
        InputAlertPage inputAlertPage = new InputAlertPage();
        inputAlertPage.clickInputAlertMenu()
                .clickAlertInputBoxButton()
                .inputAlertValue("Vasya Pupkin")
                .checkTextField("Vasya Pupkin");
    }
}
