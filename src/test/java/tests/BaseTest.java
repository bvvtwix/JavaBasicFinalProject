package tests;

import config.ConfigServer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import wdFactory.BrowserModes;
import wdFactory.BrowsersName;
import wdFactory.WebDriverFactory;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected  void initDriver() {
        String browserName = System.getProperty("browser", BrowsersName.CHROME.toString());
        String optionName = System.getProperty("option", BrowserModes.MAXIMAZE.toString());

        WebDriverManager.chromedriver().setup();

        driver = WebDriverFactory.create(browserName, optionName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

}
