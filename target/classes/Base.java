package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//data.properties");

        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if(browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//src//main//java//resources//chromedriver.exe");

            ChromeOptions options = new ChromeOptions();

            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
        }
        else if (browserName.contains("firefox")) {
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "//src//main//java//resources//geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browserName.contains("IE")) {
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "//src//main//java//resources//IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public String getScreenshot(WebDriver driver, String failedTestCase) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\screenshots\\"+ failedTestCase + ".png";
        FileUtils.copyFile(src, new File(destinationFile));
        return destinationFile;
    }

    public WebDriverWait explicitWait(WebDriver driver, int timeInSeconds) {
        WebDriverWait expWait = new WebDriverWait(driver,timeInSeconds);
        return expWait;
    }
}
