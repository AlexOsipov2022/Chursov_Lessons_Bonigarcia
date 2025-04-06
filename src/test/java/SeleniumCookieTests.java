import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CookiesPage;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumCookieTests {

    private WebDriver driver;
    private CookiesPage cookiesPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver(); // Инициализируем драйвер
        cookiesPage = new CookiesPage(driver); // Передаем драйвер в CookiesPage
        cookiesPage.navigateToPage();  // Переходим на страницу
    }

    @Test
    void AddCookieTest() {
        driver.manage().addCookie(new Cookie("myCookie", "Hello Cookie"));
        Cookie cookie = driver.manage().getCookieNamed("myCookie");

        assertNotNull(cookie, "Cookie не добавлено!");
        cookiesPage.clickDisplayCookies();

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./page_after_add_cookie.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void DeleteCookietest() throws IOException {
        driver.manage().addCookie(new Cookie("myCookie_1", "Hello Cookie_1"));
        driver.manage().addCookie(new Cookie("myCookie_2", "Hello Cookie_2"));
        driver.manage().deleteCookieNamed("myCookie_1");

        Set<Cookie> cookies = driver.manage().getCookies();
        boolean isCookieDeleted = cookies.stream()
                .noneMatch(c -> c.getName().equals("myCookie_1"));

        assertTrue(isCookieDeleted, "Cookie с именем 'myCookie_1' не удалена!");

        cookiesPage.clickDisplayCookies();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./page_after_delete_cookie.png"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрываем браузер после каждого теста
        }
    }
}