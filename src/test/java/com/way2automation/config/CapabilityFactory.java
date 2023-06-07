package com.way2automation.config;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {
    public Capabilities capabilities;
//    public Capabilities getCapabilities (BrowserType type) {
//        switch (type){
//            case FIREFOX: return capabilities = OptionsManager.getFirefoxOptions();
//            case IE:return capabilities = OptionsManager.getIEOptions();
//            case YANDEX:return capabilities = OptionsManager.getYandexDriver();
////            case OPERA:return capabilities =
//            case EDGE:return capabilities = OptionsManager.getEdgeDriver();
//            default: case CHROME: return capabilities = OptionsManager.getChromeOptions();
//        }
//    }

    public Capabilities getCapabilities (String browser) {
        if (browser.equals("firefox"))
            capabilities = OptionsManager.getFirefoxOptions();
        else
            capabilities = OptionsManager.getChromeOptions();
        return capabilities;
    }
}
