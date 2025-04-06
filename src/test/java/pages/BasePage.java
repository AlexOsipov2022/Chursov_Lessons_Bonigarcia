package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait10;
    protected WebDriverWait wait5;
    protected WebDriverWait wait2;

    // Конструктор по умолчанию для BasePage
    public BasePage() {
        // Конструктор без параметров
    }

    public void initDriver() {
        this.driver = new ChromeDriver(); // Инициализация драйвера
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Установка таймаутов
        this.wait10 = new WebDriverWait(driver, Duration.ofSeconds(10)); // Инициализация WebDriverWait
        this.wait5 = new WebDriverWait(driver, Duration.ofSeconds(5)); // Инициализация WebDriverWait
        this.wait2 = new WebDriverWait(driver, Duration.ofSeconds(2)); // Инициализация WebDriverWait
        PageFactory.initElements(driver, this); // Инициализация элементов страницы
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}