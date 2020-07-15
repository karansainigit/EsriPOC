package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoggedInPageObjects {

    public WebDriver driver;

    public LoggedInPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(@href,'new')]/div")
    private WebElement newStory;

    public WebElement clickNewStory() {
        return newStory;
    }

    @FindBy(xpath = "//textarea[@placeholder='Title your story']")
    private WebElement titleOfStory;

    public WebElement enterTitleOfStory() {
        return titleOfStory;
    }

    @FindBy(xpath = "//textarea[contains(@placeholder,'optional')]")
    private WebElement optionalText;

    public WebElement enterOptionalText() {
        return optionalText;
    }

    @FindBy(xpath = "//button[text()='Add image or video']")
    private WebElement addImageOrVideo;

    public WebElement clickAddImageOrVideo() {
        return addImageOrVideo;
    }

    @FindBy(xpath = "//button[text()='Browse your files']")
    private WebElement browseYourFiles;

    public WebElement clickBrowseYourFiles() {
        return browseYourFiles;
    }

    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement deleteUploadedImage;

    public WebElement getDeleteUploadedImage() {
        return deleteUploadedImage;
    }

    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addUploadedImage;

    public WebElement clickAddUploadedImage() {
        return addUploadedImage;
    }

    @FindBy(xpath = "//button[@aria-label='Delete']/span")
    private WebElement deleteCoverImage;

    public WebElement getDeleteCoverImage() {
        return deleteCoverImage;
    }

    @FindBy(xpath = "(//div[@title='Add content block'])[2]")
    private WebElement addContentSecond;

    public WebElement clickAddContentSecond() {
        return addContentSecond;
    }

    @FindBy(xpath = "//span[text()='Heading']")
    private WebElement addHeading;

    public WebElement clickAddHeading() {
        return addHeading;
    }

    @FindBy(xpath = "//div[contains(@class,'h2')] //h2")
    private WebElement headingText;

    public WebElement enterHeadingText() {
        return headingText;
    }

    @FindBy(xpath = "(//div[@title='Add content block'])[3]")
    private WebElement addContentThird;

    public WebElement clickAddContentThird() {
        return addContentThird;
    }

    @FindBy(xpath = "//span[text()='Image']")
    private WebElement addImage;

    public WebElement clickAddImage() {
        return addImage;
    }

    @FindBy(xpath = "//article[contains(@class,'story')]/div[3] //img[contains(@class,'image')]")
    private WebElement uploadedImage;

    public WebElement verifyUploadedImage() {
        return uploadedImage;
    }

    @FindBy(xpath = "(//div[@title='Add content block'])[4]")
    private WebElement addContentFourth;

    public WebElement clickAddContentFourth() {
        return addContentFourth;
    }

    @FindBy(xpath = "//span[text()='Map']")
    private WebElement addMap;

    public WebElement clickAddMap() {
        return addMap;
    }

    @FindBy(xpath = "//button[text()='Living Atlas']")
    private WebElement livingAtlas;

    public WebElement clickLivingAtlas() {
        return livingAtlas;
    }

    @FindBy(xpath = "//div[contains(@class,'action-animation')] //h5")
    private List<WebElement> livingAtlasMap;

    public List<WebElement> chooseLivingAtlasMap() {
        return livingAtlasMap;
    }

    @FindBy(xpath = "//button[text()='Place map']")
    private WebElement placeMap;

    public WebElement clickPlaceMap() {
        return placeMap;
    }

    @FindBy(xpath = "//div[contains(@class,'web-map')] //canvas")
    private WebElement selectedMap;

    public WebElement verifySelectedMap() {
        return selectedMap;
    }

    @FindBy(xpath = "//a[@aria-label='Stories']")
    private WebElement goBackToMyStories;

    public WebElement clickGoBackToMyStories() {
        return goBackToMyStories;
    }

    @FindBy(xpath = "//div[contains(@class,'card-body')] //h5")
    private WebElement storyTitle;

    public WebElement getStoryTitle() {
        return storyTitle;
    }

    @FindBy(xpath = "//button[contains(@data-testid,'context-menu')]")
    private WebElement contextMenu;

    public WebElement clickContextMenu() {
        return contextMenu;
    }

    @FindBy(xpath = "//div[text()='Delete']")
    private WebElement deleteStory;

    public WebElement clickDeleteStory() {
        return deleteStory;
    }

    @FindBy(xpath = "//button[text()='Yes, delete']")
    private WebElement confirmDelete;

    public WebElement clickConfirmDelete() {
        return confirmDelete;
    }

    @FindBy(xpath = "//div[contains(@class,'toast present')]")
    private WebElement deleteToast;

    public WebElement verifyDeleteToast() {
        return deleteToast;
    }

    @FindBy(xpath = "//button[contains(@class,'dropdown-target')] //img[@alt='Your profile']")
    private WebElement yourProfile;

    public WebElement clickYourProfile() {
        return yourProfile;
    }

    @FindBy(xpath = "//div[text()='Sign out']")
    private WebElement signOut;

    public WebElement clickSignOut() {
        return signOut;
    }
}
