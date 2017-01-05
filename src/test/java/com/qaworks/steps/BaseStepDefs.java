package com.qaworks.steps;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseStepDefs {

    protected static WebDriver driver;

    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
    }
}
