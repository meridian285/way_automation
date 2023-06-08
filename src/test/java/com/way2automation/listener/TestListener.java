package com.way2automation.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.way2automation.screenshot.ScreenshotOnFailureRule.*;

/**
 * Класс Listener
 */

public class TestListener implements ITestListener {

    // Скрин при падении теста
    @Override
    public void onTestFailure(ITestResult result) {
        saveAllureScreenshot();
    }
}
