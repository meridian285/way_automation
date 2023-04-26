package com.way2automation.pages;

import com.way2automation.config.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class Registration
 */
public class RegistrationPage extends BasePage {
    // Поле ввода Full Name
    @FindBy(xpath = "//input[@name='name']")
    private WebElement fullNameField;
    // Поле ввода Email
    @FindBy(xpath = "//input[@name='email']")
    protected WebElement emailField;
    // Поле ввода Password
    @FindBy(xpath = "//input[@name='password']")
    protected WebElement passwordField;
    // Ссылка на страницу логина Log in
    @FindBy(xpath = "//a[@data-test-id='login-button']")
    private WebElement loginLink;

    public RegistrationPage(){
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickLoginLink(){
        loginLink.click();
        return new LoginPage();
    }
}
