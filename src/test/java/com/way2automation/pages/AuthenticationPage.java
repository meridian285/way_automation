package com.way2automation.pages;

import com.way2automation.config.Waits;
import com.way2automation.help.JSExecutor;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Page class Authentication
 */
public class AuthenticationPage extends BasePage {

    // Локатор кнопки DisplayImage
    @FindBy(xpath = "//input[@id='displayImage']")
    private WebElement displayImageButton;
    // Локатор для проверки авторизации
    @FindBy(xpath = "//img[@id='downloadImg']")
    private WebElement img;

    public AuthenticationPage() {
        driver.get("https://www.httpwatch.com/httpgallery/authentication/#showExample10");
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать кнопку DisplayImage")
    public AuthenticationPage clickDisplayImageButton() {
        displayImageButton.click();
        return this;
    }

    @Step("Проверить что картинка появилась")
    public void checkImage(){
        new JSExecutor(driver).jsMoveToElement(img);
        new Waits(driver).untilVisible(img).isDisplayed();
        Assert.assertTrue(img.isDisplayed());
    }
}
