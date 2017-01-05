package com.qaworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public abstract class BasePage<P extends BasePage> {

    protected WebDriver driver;
    protected WebDriverWait waitTime;
    private static final String PAGE_TITLE = "";
    protected static final long ELEMENT_WAIT = 10;
    protected static final long IMPLICIT_WAIT = 20;
    protected static final int PAGE_LOAD_TIMEOUT = 30;
    protected static final int POLLING_RATE = 2;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract void instantiatePage(P page);

    protected void implicitWaitMethod() {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    protected void waitForElement(ExpectedCondition expectedCondition) {
        waitTime = new WebDriverWait(driver, ELEMENT_WAIT);
        waitTime.until(expectedCondition);
    }

    protected abstract ExpectedCondition<?> getPageLoadCondition();

    protected void waitForPageToLoad(ExpectedCondition<?> expectedCondition) {

        Wait wait = new FluentWait(driver)
                .withTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(POLLING_RATE, TimeUnit.SECONDS);
        wait.until(getPageLoadCondition());
    }



}
