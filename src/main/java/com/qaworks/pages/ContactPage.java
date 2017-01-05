package com.qaworks.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage<ContactPage> {


    @FindBy(id="ContactHead")
    private WebElement contactHeader;

    @FindBy(xpath= ".//div[@id='ContactNameBox']/input")
    private WebElement contactName;

    @FindBy(xpath= ".//div[@id='ContactEmailBox']/input")
    private WebElement contactEmail;

    @FindBy(xpath="//div[@id='ContactMessageBox']/textarea")
    private WebElement contactMessage;

    @FindBy(xpath=".//div[@id='ContactSend']/input")
    private WebElement sendButton;



    public ContactPage(WebDriver driver) {
        super(driver);
        instantiatePage(this);
        waitForPageToLoad(getPageLoadCondition());
    }

    private static final Logger LOGGER = Logger.getLogger(ContactPage.class);

    @Override
    protected void instantiatePage(ContactPage page) {
        try {
            PageFactory.initElements(driver,page);
        } catch(Exception ex) {
            LOGGER.error("Instantiation failed");
        }
    }

    @Override
    protected ExpectedCondition<?> getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(contactHeader);
    }

    public ContactPage enterDetails(String name, String email, String message) throws Exception {
        contactName.clear();
        contactName.sendKeys(name);
        contactEmail.clear();
        contactEmail.sendKeys(email);
        contactMessage.clear();
        contactMessage.sendKeys(message);
        sendButton.click();
        return new ContactPage(driver);
    }

}
