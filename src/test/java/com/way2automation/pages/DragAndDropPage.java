package com.way2automation.pages;

import com.way2automation.help.CustomActions;
import com.way2automation.help.SwitchTo;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * DragAndDropPage class
 */

public class DragAndDropPage extends BasePage {
    // Локатор элемента 1
    @FindBy(css = "div#draggable:first-of-type")
    private WebElement draggableElement;
    // Локатор элемента 2
    @FindBy(xpath = "//div[@id='droppable']")
    private WebElement droppableElement;
    // Локатор фрейма
    @FindBy(xpath = "//iframe[@src='droppable/default.html']")
    private WebElement frame;

    public DragAndDropPage() {
        driver.get("http://way2automation.com/way2auto_jquery/droppable.php");
        PageFactory.initElements(driver, this);
    }

    @Step("Перетащить элемент 1 на элемент 2")
    public DragAndDropPage dragAndDropTest() {
        new SwitchTo(driver).switchToFrame(frame);
        new CustomActions(driver).buildDragAndDrop(draggableElement, droppableElement);
        return this;
    }

    @Step("Проверить что элемент 1 перетянулся на элемент 2")
    public void checkDragAndDrop(){
        Assert.assertEquals(droppableElement.getText(), "Dropped!", "Ожидалась надпись - Dropped! на элементе");
    }
}
