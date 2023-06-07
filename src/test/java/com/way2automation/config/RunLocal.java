package com.way2automation.config;

import com.way2automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class RunLocal {

    protected static WebDriver driver;

    protected static ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<>();
    protected CapabilityFactory capabilityFactory = new CapabilityFactory();

    public void runLocal(String browser){
        driver = DriverFactory.getDrive(browser);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BasePage.setDriver(driver);
    }

    public void tearDown(){
        driver.quit();
    }

    public void runRemote(String browser) throws MalformedURLException {
        remoteDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        remoteDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        remoteDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BasePage.setDriver(remoteDriver.get());
    }

}
