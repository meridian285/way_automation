package com.way2automation.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class OptionsManager {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--incognito");
        options.addArguments("window-size=1400,1000");
        return options;
    }

    public static Capabilities getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--width=1400");
        options.addArguments("--height=800");
        return options;
    }

    public static Capabilities getIEOptions() {
        InternetExplorerOptions options = new InternetExplorerOptions();
//        options.setCapability("ie.edgechromium", true); // настройка для запуска на w10-11
        options.setCapability("ignoreProtectedModeSettings", true);
        options.setCapability("ignoreZoomSetting", true);
        return options;
    }

    public static Capabilities getYandexDriver() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.addArguments("window-size=1400,1000");
        return options;
    }

//    public static Capabilities getOperaDriver() {
//        OperaDriverManager operaDriverManager = new OperaDriverManager();
//        return operaDriverManager;
//    }

    static Capabilities getEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--width=1400");
        options.addArguments("--height=1024");
        return options;
    }
}
