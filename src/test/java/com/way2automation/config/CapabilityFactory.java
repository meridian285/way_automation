package com.way2automation.config;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {
    public Capabilities capabilities;

    public Capabilities getCapabilities(String browser) {
        switch (browser) {
            case "firefox":
                capabilities = OptionsManager.getFirefoxOptions();
                break;
            case "yandex":
                capabilities = OptionsManager.getYandexDriver();
                break;
            case "ie":
                capabilities = OptionsManager.getIEOptions();
                break;
            case "opera":
                capabilities = OptionsManager.getOperaDriver();
                break;
            default:
                capabilities = OptionsManager.getChromeOptions();
                break;
        }
        return capabilities;
    }
}
