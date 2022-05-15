package tests;

import config.ConfigServer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class BaseTest {

    protected ConfigServer cfg = ConfigFactory.create(ConfigServer.class);
    protected WebDriver driver;

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected  void initDriver(String mode) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(mode);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
