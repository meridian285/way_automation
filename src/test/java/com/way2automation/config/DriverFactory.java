package com.way2automation.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

/**
 *  BrowserFabric class
 */
public class DriverFactory {

    public static WebDriver getDrive(String type){
            switch (type){
                case "firefox": return getFirefoxDriver();
                case "EDGE": return getEdgeDriver();
                case "OPERA": return getOperaDriver();
                case "IE": return getIEDriver();
                case "YANDEX":return getYandexDriver();
                default: return getChromeDriver();
            }
    }

    private static WebDriver getChromeDriver() {
        return new ChromeDriver(OptionsManager.getChromeOptions());
    }

    private static WebDriver getOperaDriver() {
        return new ChromeDriver((ChromeDriverService) OptionsManager.getOperaDriver());
    }

    private static WebDriver getFirefoxDriver() {
        return new FirefoxDriver((FirefoxOptions) OptionsManager.getFirefoxOptions());
    }

    private static WebDriver getIEDriver() {
        return new InternetExplorerDriver((InternetExplorerOptions) OptionsManager.getIEOptions());
    }

    private static WebDriver getEdgeDriver(){
        return new EdgeDriver((EdgeOptions) OptionsManager.getEdgeOptions());
    }

    private static WebDriver getYandexDriver() {
        return new ChromeDriver((ChromeDriverService) OptionsManager.getYandexDriver());
    }
}