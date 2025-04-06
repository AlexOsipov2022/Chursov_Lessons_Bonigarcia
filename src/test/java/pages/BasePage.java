package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Конструктор по умолчанию для BasePage
    public BasePage() {
        // Конструктор без параметров
    }

    // Метод для инициализации драйвера и WebDriverWait
    public void initDriver() {
        this.driver = new ChromeDriver(); // Инициализация драйвера
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Установка таймаутов
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Инициализация WebDriverWait
        PageFactory.initElements(driver, this); // Инициализация элементов страницы
    }

    // Метод для закрытия драйвера
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрытие браузера
        }
    }
}