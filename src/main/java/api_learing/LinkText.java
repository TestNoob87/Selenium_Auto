package api_learing;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkText {

    public static void main(String[] args) throws InterruptedException {
        // Class method | getChromeDriver | WebDriver
        WebDriver driver = DriverFactory.getChromeDriver();

        // Use try catch to handle when element of webpage not found so the code below can carry on
        try {
            // Open target page | https://the-internet.herokuapp.com/login
            driver.get("https://the-internet.herokuapp.com/login");

            //WebElement poweredByLinkTextElem = driver.findElement(By.linkText("Elemental Selenium"));
            // Find partial Link Text (only "Selenium") on Page
            WebElement poweredByLinkTextElem = driver.findElement(By.partialLinkText("Selenium"));


            String linkText = poweredByLinkTextElem.getText();
            // getAttribute use to get a Attribute from an Object
            String linkHref = poweredByLinkTextElem.getAttribute("href");
            Hyperlink hyperlink = new Hyperlink(linkText, linkHref);

            System.out.println(hyperlink.text);
            System.out.println(hyperlink.link);

        } finally {
            // Quit driver session
            driver.quit();
        }
    }

    public static class Hyperlink {

        private String text;
        private String link;

        public String text() {
            return text;
        }

        public String link() {
            return link;
        }

        public Hyperlink(String text, String link) {
            this.text = text;
            this.link = link;
        }
    }
}

