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
public class BuildingStoryStepDefs extends Base {

    public WebDriver driver;
    public WebDriverWait expWait;
    public static Logger log = (Logger) LogManager.getLogger(BuildingStoryStepDefs.class.getName());

    HomePageObjects homePage;
    SignInPageObjects signInPage;
    LoggedInPageObjects loggedInPage;

    @Before("@Story,@Regression")
    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @After("@Story,@Regression")
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            // Take a screenshot...
            String screen = getScreenshot(driver,scenario.getName());
            Reporter.addScreenCaptureFromPath(screen);
        }
        driver.quit();
        log.info("Browser closed");
    }

    @Given("^User navigates to website URL and clicks on Sign In$")
    public void userNavigatesToWebsiteURLAndClicksOnSignIn() {
        driver.get(prop.getProperty("url"));
        log.info("Home Page URL opened");

        Assert.assertEquals(driver.getTitle(),prop.getProperty("homepagetitle"));
        log.debug("Home Page title verified");

        homePage = new HomePageObjects(driver);
        expWait = explicitWait(driver,20);
        expWait.until(ExpectedConditions.visibilityOf(homePage.clickSignIn()));
        homePage.clickSignIn().click();
        log.info("User clicks on Sign In");
    }

    @And("^User Sign In using his credentials$")
    public void user_sign_in_using_his_credentials() throws Throwable {
        Assert.assertEquals(driver.getTitle(),prop.getProperty("signinpagetitle"));
        log.debug("Sign In Page title verified");

        signInPage = new SignInPageObjects(driver);
        signInPage.enterUserName().sendKeys(prop.getProperty("username"));
        log.info("UserName entered");

        signInPage.enterPassword().sendKeys(prop.getProperty("password"));
        log.info("Password entered");

        expWait.until(ExpectedConditions.visibilityOf(signInPage.clickSignIn()));
        signInPage.clickSignIn().click();
        log.info("User clicks on Sign In to login");
    }

    @When("^User clicks on New Story$")
    public void user_clicks_on_new_story() throws Throwable {
        loggedInPage = new LoggedInPageObjects(driver);

        Assert.assertTrue(loggedInPage.clickYourProfile().isDisplayed());
        log.debug("User successfully signed in");

        loggedInPage.clickNewStory().click();
        log.info("User clicks on New Story");
    }

    @And("^User Enters title of the story \"([^\"]*)\" and optional text \"([^\"]*)\"$")
    public void userEntersTitleOfTheStoryAndOptionalText(String titleOfStory, String optionalTextOfStory) throws Throwable {
        expWait.until(ExpectedConditions.visibilityOf(loggedInPage.enterTitleOfStory()));
        loggedInPage.enterTitleOfStory().sendKeys(titleOfStory);
        log.info("Title of the Story entered");

        loggedInPage.enterOptionalText().sendKeys(optionalTextOfStory);
        log.info("Optional Text of the Story entered");
    }

    @And("^User add image for the story cover$")
    public void userAddImageForTheStoryCover() throws Throwable {
        loggedInPage.clickAddImageOrVideo().click();
        log.info("User clicks on Add image or video");

        loggedInPage.clickBrowseYourFiles().click();
        log.info("User clicks on Browse your files");

        Thread.sleep(2000);

        Runtime.getRuntime().exec(prop.getProperty("autoitscriptforimage"));
        log.debug("Image uploaded successfully using AutoIT");

        expWait.until(ExpectedConditions.visibilityOf(loggedInPage.getDeleteUploadedImage()));
        Assert.assertTrue(loggedInPage.getDeleteUploadedImage().isDisplayed());
        log.debug("Image is successfully uploaded as Delete button is available");

        loggedInPage.clickAddUploadedImage().click();
        log.info("User clicks on Add to add image is cover");

        expWait.until(ExpectedConditions.visibilityOf(loggedInPage.getDeleteCoverImage()));
        Assert.assertTrue(loggedInPage.getDeleteCoverImage().isDisplayed());
        log.debug("Image is successfully uploaded as Cover Image");
    }

    @And("^User enters some text as Heading for the story \"([^\"]*)\"$")
    public void userEntersSomeTextAsHeadingForTheStory(String text) throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");

        loggedInPage.clickAddContentSecond().click();
        log.info("User clicks on add content");

        loggedInPage.clickAddHeading().click();
        log.info("User clicks on Heading");

        Thread.sleep(2000);

        loggedInPage.enterHeadingText().sendKeys(text);
        log.info("Heading text entered");
    }

    @And("^User choose any image for the story$")
    public void userChooseAnyImageForTheStory() throws Throwable {
        loggedInPage.clickAddContentThird().click();
        log.info("User clicks on add content");

        loggedInPage.clickAddImage().click();
        log.info("User clicks on Image");

        loggedInPage.clickBrowseYourFiles().click();
        log.info("User clicks on Browse your files");

        Thread.sleep(2000);

        Runtime.getRuntime().exec(prop.getProperty("autoitscriptforimage"));
        log.debug("Image uploaded successfully using AutoIT");

        expWait.until(ExpectedConditions.visibilityOf(loggedInPage.getDeleteUploadedImage()));
        Assert.assertTrue(loggedInPage.getDeleteUploadedImage().isDisplayed());
        log.debug("Image is successfully uploaded as Delete button is available");

        loggedInPage.clickAddUploadedImage().click();
        log.info("User clicks on Add to add image is cover");

        expWait.until(ExpectedConditions.visibilityOf(loggedInPage.verifyUploadedImage()));
        Assert.assertTrue(loggedInPage.verifyUploadedImage().isDisplayed());
        log.debug("Uploaded Image verified");
    }

    @And("^User choose Living Atlas map \"([^\"]*)\" for the story$")
    public void userChooseLivingAtlasMapForTheStory(String map) throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");

        loggedInPage.clickAddContentFourth().click();
        log.info("User clicks on add content");

        loggedInPage.clickAddMap().click();
        log.info("User clicks on Map");

        expWait.until(ExpectedConditions.visibilityOf(loggedInPage.clickLivingAtlas()));
        loggedInPage.clickLivingAtlas().click();
        log.info("User clicks on Living Atlas");

        for(int i = 0; i < loggedInPage.chooseLivingAtlasMap().size(); i++) {
            if(loggedInPage.chooseLivingAtlasMap().get(i).getText().contains(map)) {
                loggedInPage.chooseLivingAtlasMap().get(i).click();
                log.info("Living Atlas map selected");
                break;
            }
        }

        expWait.until(ExpectedConditions.elementToBeClickable(loggedInPage.clickPlaceMap()));
        loggedInPage.clickPlaceMap().click();
        log.info("Chosen Living Atlas map placed in story");

        js.executeScript("window.scrollBy(0,300)");

        expWait.until(ExpectedConditions.visibilityOf(loggedInPage.verifySelectedMap()));
        Assert.assertTrue(loggedInPage.verifySelectedMap().isDisplayed());
        log.debug("Selected Map verified");
    }

    @Then("^Verify Story \"([^\"]*)\" is created successfully by going to My Stories$")
    public void verifyStoryIsCreatedSuccessfullyByGoingToMyStories(String storyName) throws Throwable {
        loggedInPage.clickGoBackToMyStories().click();
        log.info("User go back to My Stories page");

        expWait.until(ExpectedConditions.visibilityOf(loggedInPage.getStoryTitle()));
        Assert.assertEquals(loggedInPage.getStoryTitle().getText(),storyName);
        log.debug("Created Story verified");
    }

    @And("^User Sign Out from account$")
    public void userSignOutFromAccount() {
        loggedInPage.clickYourProfile().click();
        log.info("User click on his profile");

        loggedInPage.clickSignOut().click();
        log.info("User click on Sign Out");

        try
        {
            driver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException Ex)
        {
            log.debug("No Alert present");
        }

        expWait.until(ExpectedConditions.visibilityOf(homePage.clickSignIn()));
        Assert.assertTrue(homePage.clickSignIn().isDisplayed());
        log.debug("Sign Out Successfully");
    }

    @Then("^Verify Story \"([^\"]*)\" is already present$")
    public void verifyStoryIsAlreadyPresent(String storyName) throws Throwable {
        loggedInPage = new LoggedInPageObjects(driver);

        expWait.until(ExpectedConditions.visibilityOf(loggedInPage.getStoryTitle()));
        Assert.assertEquals(loggedInPage.getStoryTitle().getText(),storyName);
        log.debug("Already Created Story verified");
    }

    @And("^Delete the Story and verify its successfully deleted$")
    public void deleteTheStoryAndVerifyItsSuccessfullyDeleted() {
        loggedInPage.clickContextMenu().click();
        log.info("User click on Context Menu for Story");

        loggedInPage.clickDeleteStory().click();
        log.info("User click on Delete");

        loggedInPage.clickConfirmDelete().click();
        log.info("User confirm Delete");

        expWait.until(ExpectedConditions.visibilityOf(loggedInPage.verifyDeleteToast()));
        Assert.assertTrue(loggedInPage.verifyDeleteToast().isDisplayed());
        log.debug("Deletion verified");
    }
}
