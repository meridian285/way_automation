package com.way2automation.tests;

import com.way2automation.config.CapabilityFactory;
import com.way2automation.config.DriverFactory;
import com.way2automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.IOException;
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
    public void runRemote(String browser, String url) {
        try {
            remoteDriver.set(new RemoteWebDriver(new URL(url), capabilityFactory.getCapabilities(browser)));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BasePage.setDriver(getDriver());
    }

    public WebDriver getDriver() {
        return remoteDriver.get();
    }

    // BeforeMethod с параметрами из xml
    @Parameters(value = {"browser", "url", "environment"})
    @BeforeMethod
    public void setUp(String browser, String url, String environment) {
        if (environment.equals("remote")) {
            try {
                Runtime.getRuntime().exec("cmd /c START_HUB.bat");
                Thread.sleep(3000);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            runRemote(browser, url);
        } else
            runLocal(browser);
    }

    @Parameters(value = {"browser", "url", "environment"})
    @AfterMethod
    public void tearDown(String browser, String url, String environment) {
        if (environment.equals("remote")) {
            getDriver().quit();
        } else{
            driver.quit();
        }
    }

    @AfterClass
    void terminate () {
        remoteDriver.remove();
    }
}