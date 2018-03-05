package opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Buying {
    private WebDriver driver;
    private String URL = "http://opencartt.rf.gd/";

    @BeforeClass
    public  void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/Selenium/chromedriver.exe");

        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAddToCart() {
        driver.get(URL);

    }
}
