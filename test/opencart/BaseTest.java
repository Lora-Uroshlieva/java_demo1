package opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    static WebDriver driver;

    @BeforeClass
    public void setupClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Java/Selenium/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
