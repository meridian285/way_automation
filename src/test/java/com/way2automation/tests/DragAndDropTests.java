package com.way2automation.tests;

import com.way2automation.pages.DragAndDropPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

/**
 * Тестовый класс для тестов DragAndDrop
 */

@Epic(value = "Заполнение формы")
@Feature(value = "Регистрация пользователя")
public class DragAndDropTests extends BaseTest {

    @Test(description = "Тест DragAndDrop")
    public void checkDragAndDrop() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage();
        dragAndDropPage.dragAndDropTest()
                .checkDragAndDrop();
    }
}
