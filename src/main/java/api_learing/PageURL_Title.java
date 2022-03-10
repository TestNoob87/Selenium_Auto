package api_learing;

import Driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class PageURL_Title {

    public static void main(String[] args) throws InterruptedException {
        // Class method | getChromeDriver | WebDriver
        WebDriver driver = DriverFactory.getChromeDriver();

        // Use try catch to handle when element of webpage not found so the code below can carry on
        try {
            // Open target page | https://the-internet.herokuapp.com/login
            driver.get("https://the-internet.herokuapp.com/login");

            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());


        } finally {
            // Quit driver session
            driver.quit();
        }
    }

}
