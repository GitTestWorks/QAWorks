package com.qaworks.runner;

import com.qaworks.steps.BaseStepDefs;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features= {"src/test/resources/cucumber/ContactUs.feature"},
        glue= {"com/qaworks/steps/"},
        tags= "@Contact",
        monochrome = true,
        plugin = {"json:target/cucumber-report-contact-feature.json"}
)
public class RunCukesContactFeature extends BaseStepDefs {

        private TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass(alwaysRun = true)
        public void setup() throws Exception {
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }

        @Test(groups = "cucumber",description = "Cucumber Feature",dataProvider = "features")
        public void feature(CucumberFeatureWrapper cucumberFeatureWrapper) {
            testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
        }

        @DataProvider
        public Object[][] features() {
            return testNGCucumberRunner.provideFeatures();
        }

        @AfterClass(alwaysRun = true)
        public void teardown() throws Exception {
            testNGCucumberRunner.finish();
        }
    }

