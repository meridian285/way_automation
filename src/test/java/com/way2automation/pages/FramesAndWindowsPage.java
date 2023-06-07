package com.way2automation.pages;

import com.way2automation.config.Waits;
import com.way2automation.help.SwitchTo;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * FramesAndWindowsPage class
 */
public class FramesAndWindowsPage extends BasePage {

    // Локатор фрейма frames-windows
    @FindBy(xpath = "//iframe[@src='frames-windows/defult1.html']")
    private WebElement frame;
    // Локатор ссылки New Browser Tab
    @FindBy(xpath = "//a[text()='New Browser Tab']")
    private WebElement newBrowserTabLink;

    public FramesAndWindowsPage() {
        driver.get("http://way2automation.com/way2auto_jquery/frames-and-windows.php");
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать на ссылку")
    public void clickNewBrowserTab() {
        new Waits(driver).untilElementToBeClickable(newBrowserTabLink).click();
    }

    @Step("Переключиться на frame")
    public FramesAndWindowsPage switchToFrame(){
        new SwitchTo(driver).switchToFrame(frame);
        return this;
    }
}
