import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.CookiesPage;

import java.time.Duration;

public class SeleniumCookieTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private CookiesPage cookiesPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        cookiesPage = new CookiesPage(driver, wait);
    }

    @Test
    void AddCookieTest() {
        driver.manage().addCookie(new Cookie("myCookie", "HelloCookie"));
        cookiesPage.clickDisplayCookies();
    }

    @Test
    void DeleteCookietest() {
        driver.manage().addCookie(new Cookie("myCookie", "HelloCookie"));
        driver.manage().deleteCookieNamed("myCookie");

        cookiesPage.clickDisplayCookies();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
