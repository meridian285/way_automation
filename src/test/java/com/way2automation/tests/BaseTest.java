package com.way2automation.tests;

import com.way2automation.help.TestRetry;
import com.way2automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BasePage.setDriver(driver);
    }

    @AfterMethod
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