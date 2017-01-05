package com.qaworks.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.security.InvalidParameterException;

public class DriverFactory {

    public enum Driver {
        FIREFOX,
        CHROME,
        IE,
        HTMLUNIT,
    }

    /**
     *
     * @param driverType
     * @return browser
     */
    public WebDriver getDriver(Driver driverType){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        switch (driverType) {

            case FIREFOX:
                // Disable Native Events on Windows for Firefox Driver.
                try {
                    FirefoxProfile firefoxProfile = new FirefoxProfile();
                    firefoxProfile.setEnableNativeEvents(true);
                    desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

                    return new FirefoxDriver(desiredCapabilities);

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            case CHROME:
                if (null==System.getProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY)){
                    System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");

                }
                try {
                     return new ChromeDriver(desiredCapabilities);
                    }

                catch (Exception ex) {
                    ex.printStackTrace();
                    return null;
                }
            case IE:
                try {
                    desiredCapabilities.setCapability(InternetExplorerDriver.SILENT, true);
                    //desiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
                    desiredCapabilities.setCapability("EnableNativeEvents", true);
                    desiredCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
                    return new InternetExplorerDriver(desiredCapabilities);

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }

            case HTMLUNIT:
                return new HtmlUnitDriver(true);
            default:
                throw new InvalidParameterException("You must choose one of the defined driver types");

        }
    }
}
