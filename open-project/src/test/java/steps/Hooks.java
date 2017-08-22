package steps;

import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverWait wait;
    ScreenshotHelpers screenshotHelper;

    @Before
    public void openBrowser() throws MalformedURLException {
        System.out.println("Called openBrowser");
        screenshotHelper = new ScreenshotHelpers();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }

    public class ScreenshotHelpers{

        public void saveScreenshot(String screenshotFileName) throws IOException {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destDir = new File("./screenshots", screenshotFileName);
            FileUtils.copyFileToDirectory(screenshot, destDir);
        }
    }

}
