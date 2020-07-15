package stepdefinitions;

import com.cucumber.listener.Reporter;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.HomePageObjects;
import pageobjects.LoggedInPageObjects;
import pageobjects.SignInPageObjects;
import resources.Base;

import java.io.IOException;

@RunWith(Cucumber.class)
public class FailTestCasesStepDefs extends Base {

    public WebDriver driver;
    public static Logger log = (Logger) LogManager.getLogger(FailTestCasesStepDefs.class.getName());

    public HomePageObjects homePageObjects;

    @Before("@Fail")
    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @After("@Fail")
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            // Take a screenshot...
            String screen = getScreenshot(driver,scenario.getName());
            Reporter.addScreenCaptureFromPath(screen);
        }
        driver.quit();
        log.info("Browser closed");
    }

    @Given("^User navigates to website URL$")
    public void userNavigatesToWebsiteURL() {
        driver.get(prop.getProperty("url"));
        log.info("Home Page URL opened");
    }

    @Then("^Verify heading of the Home Page should be \"([^\"]*)\"$")
    public void verifyHeadingOfTheHomePageShouldBe(String heading) throws Throwable {
        homePageObjects = new HomePageObjects(driver);

        Assert.assertEquals(homePageObjects.getHomePageHeading().getText(),heading);
        log.debug("Heading of Home Page Verified");
    }


    @Then("^Verify Logo should be displayed on the Home Page$")
    public void verifyLogoShouldBeDisplayedOnTheHomePage() {
        homePageObjects = new HomePageObjects(driver);

        Assert.assertTrue(homePageObjects.getHomePageLogo().isDisplayed());
        log.debug("Logo of Home Page verified");
    }
}
