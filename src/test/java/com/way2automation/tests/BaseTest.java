package com.way2automation.tests;

import com.way2automation.help.TestRetry;
import com.way2automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        BasePage.setDriver(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    // Перезапуск упавших тестов
    @BeforeSuite
    public void testRetry(ITestContext iTestContext){
        for (ITestNGMethod method: iTestContext.getAllTestMethods()){
            method.setRetryAnalyzerClass(TestRetry.class);
        }
    }
}