package com.way2automation.pages;

import com.way2automation.config.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Page class Dummy Registration Form
 */
public class DummyRegistrationPage extends BasePage {
    // Поле регистрации Name
    @FindBy(name = "name")
    private WebElement nameField;
    // Поле регистрации Phone
    @FindBy(name = "phone")
    private WebElement phoneField;
    // Поле регистрации Email
    @FindBy(name = "email")
    private WebElement emailField;
    // Локатор списка Country
    @FindBy(name = "country")
    private WebElement countryList;
    // Поле регистрации City
    @FindBy(name = "city")
    private WebElement cityField;
    // Поле регистрации Username
    @FindBy(xpath = "//div[@class='fancybox-inner']//input[@name='username']")
    private WebElement usernameField;
    // Поле регистрации Password
    @FindBy(xpath = "//div[@class='fancybox-inner']//input[@name='password']")
    private WebElement passwordField;
    // Кнопка формы регистрации Submit
    @FindBy(xpath = "//div[@class='fancybox-inner']//input[@class='button']")
    private WebElement submitButton;
    // Всплывающее сообщение
    @FindBy(xpath = "//p[@id='alert']")
    private WebElement alertMessage;

    Waits wait = new Waits(driver);

    public DummyRegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Ввести данные в форму")
    public DummyRegistrationPage signUpRegistrationForm(String name, String phone, String email, String country, String city,
                                       String username, String password) {
        nameField.sendKeys(name);
        phoneField.sendKeys(phone);
        emailField.sendKeys(email);
        countryList.sendKeys(country);
        cityField.sendKeys(city);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        return this;
    }

    private boolean isMessagePresent() {
            return wait.untilTextToBePresentInElement(alertMessage,
                    "This is just a dummy form, you just clicked SUBMIT BUTTON");
    }

    @Step("Проверить наличие сообщения")
    public void checkMessagePresent(boolean check){
        Assert.assertEquals(isMessagePresent(), check, "Результат не соответствует ожидаемому");
    }
}
