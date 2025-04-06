package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver != null ? driver : new ChromeDriver();  // Если driver не передан, создаем новый
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));  // Установка таймаутов
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Инициализация ожидания
        PageFactory.initElements(driver, this);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}