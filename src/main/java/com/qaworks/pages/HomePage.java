package com.qaworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage<HomePage> {

    @FindBy(id = "AboutUsHeaderDesc")
    private WebElement headerText;

    HeaderNav headerNav;


    public HomePage(WebDriver driver) {
        super(driver);
        instantiatePage(this);
        waitForPageToLoad(getPageLoadCondition());
        headerNav = new HeaderNav(driver);
    }

    //private static final Logger LOGGER = LoggerFactory.getLogger(SignInPage.class);

    @Override
    protected void instantiatePage(HomePage page) {
        try {
            PageFactory.initElements(driver,page);
        } catch(Exception ex) {
//            LOGGER.error("Instantiation failed");
        }
    }

    @Override
    protected ExpectedCondition<?> getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(headerText);
    }


    public void setHeaderNav(HeaderNav headerNav) {
        this.headerNav = headerNav;
    }

    public HeaderNav getHeaderNav() {
        return headerNav;
    }
}
