package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesPage extends BasePage{

    @FindBy(id = "refresh-cookies")
    private WebElement DisplayCookies;

    public CookiesPage(WebDriver driver, WebDriverWait wait) {
        super(); // Вызов конструктора BasePage без параметров
        this.driver = driver; // Инициализация драйвера
        this.wait10 = wait;
        this.wait5 = wait;
        this.wait2 = wait;
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
    }

    public void clickDisplayCookies() {
        DisplayCookies.click();
    }
}
