package com.way2automation.pages;

import com.way2automation.config.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurityPage extends BasePage {
    // CheckBox для подтверждения что не бот
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkBox;

    public SecurityPage(){
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage clickCheckBox() {
        checkBox.click();
        return new RegistrationPage();
    }
}
