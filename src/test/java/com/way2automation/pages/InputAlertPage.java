package com.way2automation.pages;

import com.way2automation.help.SwitchTo;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputAlertPage extends BasePage{

    @FindBy(xpath = "//a[text() = 'Input Alert']")
    private WebElement inputAlertMenu;

    @FindBy(xpath = "//iframe[@src='alert/input-alert.html']")
    private WebElement frameAlert;

    @FindBy(xpath = "//button[text()='Click the button to demonstrate the Input box.']")
    private WebElement alertInputBoxButton;

    @FindBy(xpath = "//p[@id='demo']")
    private WebElement textField;

    public InputAlertPage(){
        driver.get("http://way2automation.com/way2auto_jquery/alert.php");
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать на пункт меню Input Alert")
    public InputAlertPage clickInputAlertMenu(){
        inputAlertMenu.click();
        return this;
    }

    @Step
    public InputAlertPage switchToFrame(){
        new SwitchTo(driver).switchToFrame(frameAlert);
        return this;
    }

    @Step("Нажать на кнопку - Click the button to display an alert box:")
    public void clickAlertInputBoxButton(){
        new SwitchTo(driver).switchToFrame(frameAlert);
        alertInputBoxButton.click();
    }

    @Step("Проверить что появился введенный текст")
    public String getTextField(){
        return textField.getText();
    }
}
