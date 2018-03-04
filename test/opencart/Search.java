package opencart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Search {
    private WebDriver driver;
    private final String URL = "http://opencartt.rf.gd/";
    private final String SEARCH_INPUT_LOCATOR = "input.form-control.input-lg";
    private final String SEARCH_BUTTON_LOCATOR = ".btn.btn-default.btn-lg";


    @BeforeClass
    public  void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/lurostc/IdeaProjects/libs/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        options.addArguments("--headless");
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);


//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSearch() {
        driver.get(URL);
        WebElement input = driver.findElement(
                By.cssSelector(SEARCH_INPUT_LOCATOR));
        input.clear();
        input.sendKeys("Apple Cinema");
        driver.findElement(By.cssSelector(SEARCH_BUTTON_LOCATOR)).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Assert.assertEquals(driver.getCurrentUrl(),
                "http://opencartt.rf.gd/index.php?route=product/search&search=Apple%20Cinema");
        WebElement link = driver.findElement(By.partialLinkText("Apple Cinema"));
        Assert.assertEquals(link.getText(), "Apple Cinema 30\"");
    }
}
