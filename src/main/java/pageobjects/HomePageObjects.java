package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

    public WebDriver driver;

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Sign in")
    private WebElement signIn;

    public WebElement clickSignIn() {
        return signIn;
    }

    @FindBy(xpath = "//a[contains(@class,'logo-link')]/following-sibling::h1")
    private WebElement homePageHeading;

    public WebElement getHomePageHeading() {
        return homePageHeading;
    }

    @FindBy(xpath = "//main //img[contains(@class,'homepagelogo')]")  //logo
    private WebElement homePageLogo;

    public WebElement getHomePageLogo() {
        return homePageLogo;
    }
}
