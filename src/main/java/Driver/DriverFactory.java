package Driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver() {

        String chromeDriverLocation;
        String currentProjectLocation = System.getProperty("user.dir");
        chromeDriverLocation = OS.isFamilyMac()
                ? currentProjectLocation.concat("/src/test/resources/drivers/chromedriver")
                : currentProjectLocation.concat("\\src\\test\\resources\\drivers\\chromedriver.exe");

        // Chrome Browser option
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        //Start Browser session
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        //Open WebPage
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
