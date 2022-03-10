package api_learing;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormHandling {

    public static void main(String[] args) throws InterruptedException {
        // Class method | getChromeDriver | WebDriver
        WebDriver driver = DriverFactory.getChromeDriver();

        // Use try catch to handle when element of webpage not found so the code below can carry on
        try {
            // Open target page | https://the-internet.herokuapp.com/login
            driver.get("https://the-internet.herokuapp.com/login");

            // Find username/password Element by using username/password Selector
            WebElement usernameElem = driver.findElement(By.name("username"));
            WebElement passwordElem = driver.findElement(By.cssSelector("#password"));

            // Input username/password
            usernameElem.sendKeys("Testing Name");
            usernameElem.clear(); // Delete input
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("123456");
            passwordElem.clear();
            passwordElem.sendKeys("SuperSecretPassword!");

            WebElement buttonLoginElem = driver.findElement(By.cssSelector("#login button[type=\"submit\"]"));
            buttonLoginElem.click();

            Thread.sleep(3000);
        } finally {
            // Quit driver session
            driver.quit();
        }

    }
}

