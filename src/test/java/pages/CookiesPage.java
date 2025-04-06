package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesPage extends BasePage{

    @FindBy(id = "refresh-cookies")
    private WebElement DisplayCookies;

    public CookiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
    }

    public void clickDisplayCookies() {
        DisplayCookies.click();
    }
}
