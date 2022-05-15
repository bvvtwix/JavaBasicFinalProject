package wdFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import java.util.Locale;

import org.openqa.selenium.opera.OperaOptions;

public class WebDriverFactory {

    public static WebDriver create(String webDriverName, String option) {

        BrowsersName command = BrowsersName.valueOf(webDriverName.toUpperCase(Locale.ROOT));

        switch (command){
            case OPERA:
                WebDriverManager.operadriver().setup();
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.addArguments(option.toLowerCase(Locale.ROOT));
                return new OperaDriver(operaOptions);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(option.toLowerCase(Locale.ROOT));
                return new ChromeDriver(chromeOptions);
        }
    }
}
