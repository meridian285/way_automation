package com.way2automation.tests;

import com.way2automation.config.Waits;
import com.way2automation.help.SwitchTo;
import com.way2automation.pages.FramesAndWindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *  Тестовый класс FramesAndWindowsTests
 */

public class FramesAndWindowsTests extends BaseTest {

    @Test(description = "Проверить что открылось 3 вкладки New Browser Tab")
    public void checkOpenNewTabs() {
        FramesAndWindowsPage framesAndWindows = new FramesAndWindowsPage();
        SwitchTo switchTo = new SwitchTo(driver);
        framesAndWindows.switchToFrame()
                .clickNewBrowserTab();
        switchTo.switchToTabs(1);
        framesAndWindows.clickNewBrowserTab();
        switchTo.switchToTabs(2);
        Assert.assertEquals(driver.getWindowHandles().size(), 3,
                "Ожидалось другое количество открытых вкладок");
    }
}