package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageObjects {

    public WebDriver driver;

    public SignInPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#user_username")
    private WebElement userName;

    public WebElement enterUserName() {
        return userName;
    }

    @FindBy(css = "#user_password")
    private WebElement password;

    public WebElement enterPassword() {
        return password;
    }

    @FindBy(id = "signIn")
    private WebElement signIn;

    public WebElement clickSignIn() {
        return signIn;
    }
}
