package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWebDriverJavaPage extends BasePage{



    public SeleniumWebDriverJavaPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
    }
}