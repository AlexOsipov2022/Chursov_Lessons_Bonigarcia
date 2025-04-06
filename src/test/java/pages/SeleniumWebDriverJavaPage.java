package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWebDriverJavaPage extends BasePage{

    @FindBy(id = "refresh-cookies")
    private WebElement DisplayCookies;
    @FindBy(id = "password")
    private WebElement passwordInput;


    public SeleniumWebDriverJavaPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = wait;
//        this.wait5 = wait;
//        this.wait2 = wait;
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
    }
}