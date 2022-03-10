import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

    public static void main(String[] args) throws InterruptedException {
        //Location of WebDriver
        String chromeDriverLocation = null;
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
        WebDriver driver = new ChromeDriver(chromeOptions); // Start Webdriver Server
        driver.get("https://www.gmail.com"); // Executed command

        Thread.sleep(3000); // Set up hold time to check

        driver.close(); //Close browser but not quit all session
        driver.quit(); //Close browser and quit all session
    }
}
