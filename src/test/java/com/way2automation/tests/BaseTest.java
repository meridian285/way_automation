package com.way2automation.tests;

import com.way2automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BasePage.setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
