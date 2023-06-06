package com.way2automation.help;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Класс для перезапуска падающих тестов
 */
public class TestRetry implements IRetryAnalyzer {
    private int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        // Условие выполняется если тест упал
        if (!iTestResult.isSuccess()) {
            int maxCount = 2;
            if (count < maxCount) {
                count++;
                return true;
            }
        }
        return false;
    }
}
