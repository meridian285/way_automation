package com.way2automation.pages;

import com.way2automation.config.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page class Log In
 */

public class LoginPage extends RegistrationPage {
    // Кнопка входа Log In
    @FindBy(xpath = "//a[@data-test-id='login-button']")
    private WebElement loginButton;

    public void singIn(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}