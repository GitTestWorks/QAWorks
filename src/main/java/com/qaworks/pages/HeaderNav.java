package com.qaworks.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderNav extends BasePage<HeaderNav> {

    @FindBy(xpath = ".//ul[@id='menu']//a[text()='Contact']")
    private WebElement contact;

    @FindBy(xpath=".//ul[@id='menu']//a[text()='Careers']")
    private WebElement careers;

    @FindBy(xpath=".//div[@id='head']")
    private WebElement headerMenu;


    public HeaderNav(WebDriver driver) {
        super(driver);
        instantiatePage(this);
        waitForPageToLoad(getPageLoadCondition());
    }

    private static final Logger LOGGER = Logger.getLogger(HeaderNav.class);

    @Override
    protected void instantiatePage(HeaderNav page) {
        try {
            PageFactory.initElements(driver,page);
        } catch(Exception ex) {
           LOGGER.error("Instantiation failed");
        }
    }

    @Override
    protected ExpectedCondition<?> getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(headerMenu);
    }

    public ContactPage navToContactPage() throws Exception {
        contact.click();
        return new ContactPage(driver);
    }
}
