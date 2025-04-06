package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiesPage extends BasePage {

    @FindBy(id = "refresh-cookies")
    private WebElement DisplayCookies;

    public CookiesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
        wait.until(ExpectedConditions.urlToBe("https://bonigarcia.dev/selenium-webdriver-java/cookies.html"));
        wait.until(ExpectedConditions.visibilityOf(DisplayCookies));
    }

    public void clickDisplayCookies() {
        DisplayCookies.click();
    }
}
