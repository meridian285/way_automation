package com.way2automation.tests;

import com.way2automation.config.CapabilityFactory;
import com.way2automation.config.DriverFactory;
import com.way2automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<>();
    protected CapabilityFactory capabilityFactory = new CapabilityFactory();

    // Настройки для локального запуска тестов
    public void runLocal(String browser) {
        driver = DriverFactory.getDrive(browser);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BasePage.setDriver(driver);
    }

    // Настройки для удаленного запуска тестов
    public void runRemote(String browser) {
        try {
            remoteDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = remoteDriver.get();
        remoteDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        remoteDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BasePage.setDriver(remoteDriver.get());
    }

    // BeforeMethod с параметрами из testng.xml
    @Parameters(value = {"browser", "environment"})
    @BeforeMethod
    public void setUp(String browser, String environment) {
        if (environment.equals("remote")) {
            runRemote(browser);
        } else
            runLocal(browser);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}