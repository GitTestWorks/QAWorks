package com.qaworks.steps;

import com.qaworks.pages.ContactPage;
import com.qaworks.pages.HomePage;
import com.qaworks.utils.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.qaworks.steps.BaseStepDefs.driver;

public class ContactUsStepDefs {
    HomePage homePage;
    ContactPage contactPage;

    @After
    public void afterScenario(Scenario scenario) throws Exception {
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
            driver.quit();
        } else
            driver.quit();
    }

    @Given("^I am on the QAWorks Site$")
    public void iAmOnTheQAWorksSite() throws Throwable {
        driver = new DriverFactory().getDriver(DriverFactory.Driver.CHROME);
        driver.get("http://www.qaworks.com/");
        Thread.sleep(3000);
        homePage = new HomePage(driver);
    }

    @Then("^I should be able to contact QAWorks$")
    public void iShouldBeAbleToContactQAWorks() throws Throwable {
        contactPage= homePage.getHeaderNav().navToContactPage();
    }

    @And("^enter \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" for contact$")
    public void enterAndForContact(String arg0, String arg1, String arg2) throws Throwable {
       contactPage.enterDetails(arg0,arg1,arg2);
    }
}
