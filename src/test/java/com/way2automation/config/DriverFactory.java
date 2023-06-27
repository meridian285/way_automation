package com.way2automation.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
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
//                case "EDGE": return getEdgeDriver();
//                case "OPERA": return getOperaDriver();
                case "IE": return getIEDriver();
                case "YANDEX":return getYandexDriver();
                default: return getChromeDriver();
            }
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=1400,1000");
        return new ChromeDriver(options);
    }

//    private static WebDriver getOperaDriver() {
//        WebDriverManager.operadriver().setup();
//        return new OperaDriverManager().getWebDriver();
//    }

//    private static WebDriver getEdgeDriver() {
//        WebDriverManager.edgedriver().setup();
//        return new EdgeDriver();
//    }

    private static WebDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--width=1400");
        options.addArguments("--height=1024");
        return new FirefoxDriver(options);
    }

    private static WebDriver getIEDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
//        options.setCapability("ie.edgechromium", true); // настройка для запуска на w10-11
        options.setCapability("ignoreProtectedModeSettings", true);
        options.setCapability("ignoreZoomSetting", true);
        return new InternetExplorerDriver(options);
    }

    private static WebDriver getYandexDriver() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.addArguments("window-size=1400,1000");
        return new ChromeDriver(options);
    }
}