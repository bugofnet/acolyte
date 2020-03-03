package utilities;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TestUtilities {

    private WebDriver driver;
    public static WebDriverWait waitDriver;
    public static final int TIMEOUT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 50;
    private Logger logger = LoggerFactory.getLogger(TestUtilities.class);


    public void initializeDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        //remove options to see tests in running browser
        options.setHeadless(true);
        Driver.driver = new FirefoxDriver(options);
        Driver.driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        Driver.driver.manage().timeouts().setScriptTimeout(TIMEOUT,TimeUnit.SECONDS);
        Driver.driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        Driver.driver.manage().window().maximize();
        waitDriver = new WebDriverWait(Driver.driver, TIMEOUT);
        logger.info("Framework starts driver: {}", Driver.driver.toString());
    }

    public void openBrowser(String url) {
        Driver.driver.get(url);
        logger.info("Browser opened ({})", url);
    }

    public void closeBrowser() {
        Driver.driver.quit();
        logger.info("Browser closed");
    }

    public void screenshotInCaseOfFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = (scenario.getName() + TimeTool.getCurrentLocalDateTime() + ".png").replace(" ", "_");
            try {
                Reporter.addScreenCaptureFromPath(ScreenshotTool.takeScreenshot(screenshotName));
            } catch (Exception e) {
                logger.error("Failure to capture a screenshot: {}", e);
            }
        }
    }

    public void deleteCookies() {
        Driver.driver.manage().deleteAllCookies();
        logger.info("All cookies deleted");
    }
}
