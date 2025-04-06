package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumWebDriverJavaPageTests {

    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void openHomePageTest() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

    @Test
    void openWebFormTest() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Web form")).click();
        WebElement pageName  = driver.findElement(By.className("display-6"));

        String urlWebFormPage = driver.getCurrentUrl();
        String currentUrl = "web-form.html";

        assertEquals(BASE_URL + currentUrl, urlWebFormPage);
        assertEquals("Web form", pageName.getText());
    }
}