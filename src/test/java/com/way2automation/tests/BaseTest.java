package com.way2automation.tests;

import com.way2automation.config.RunLocal;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

//    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
//    protected CapabilityFactory capabilityFactory = new CapabilityFactory();
//
//    public WebDriver getDriver() {
//        return driver.get();
//    }
//    @BeforeMethod
//    @Parameters(value={"browser"})
//    public void setUp(String browser) throws MalformedURLException {
//        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
//        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        BasePage.setDriver(driver.get());
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        getDriver().quit();
//    }
//
//    @AfterClass
//    void terminate() {
//        driver.remove();
//    }


protected static WebDriver driver;

    @Parameters(value = {"browser"})
    @BeforeMethod
    public void setUp(String browser) {
        new RunLocal().runLocal(browser);


//        driver = DriverFactory.getDrive(browser);
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        BasePage.setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        new RunLocal().tearDown();
    }

}