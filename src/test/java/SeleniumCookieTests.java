import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.CookiesPage;
import pages.BasePage;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumCookieTests extends BasePage {

    private CookiesPage cookiesPage;

    @BeforeEach
    void setup() {
        initDriver();
        cookiesPage = new CookiesPage(driver, wait10);
    }

    @Test
    void AddCookieTest() {
        driver.manage().addCookie(new Cookie("myCookie", "Hello Cookie"));
        Cookie cookie = driver.manage().getCookieNamed("myCookie");

        assertNotNull(cookie, "Cookie не добавлено!");
    }

    @Test
    void DeleteCookietest() {
        driver.manage().addCookie(new Cookie("myCookie_2", "Hello Cookie_2"));
        driver.manage().deleteCookieNamed("myCookie_2");

        Set<Cookie> cookies = driver.manage().getCookies();
        boolean isCookieDeleted = cookies.stream()
                .noneMatch(c -> c.getName().equals("myCookie_2"));

        assertTrue(isCookieDeleted, "Cookie с именем 'myCookie_2' не удалена!");

        cookiesPage.clickDisplayCookies();
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }
}