package com.way2automation.help;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

/**
 * Класс для перезапуска падающих тестов
 */
public class TestRetry implements IRetryAnalyzer {
    private int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        // Условие выполняется если тест упал
        if (!iTestResult.isSuccess()) {
            int maxCount = ReadProperties.MAX_COUNT;
            if (count < maxCount) {
                count++;
                return true;
            }
        }
        return false;
    }
}
