package opencart;

import opencart.util.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Search {
    private WebDriver driver;
    private final String URL = "http://opencartt.rf.gd/";
    private final String SEARCH_INPUT_LOCATOR = "input.form-control.input-lg";
    private final String SEARCH_BUTTON_LOCATOR = ".btn.btn-default.btn-lg";


    @BeforeClass
    public  void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/Selenium/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        options.addArguments("--headless");  //uncomment this for running without chrome UI
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSearchSingleProduct() {
        driver.get(URL);
        WebElement input = driver.findElement(By.cssSelector(SEARCH_INPUT_LOCATOR));
        input.clear();
        input.sendKeys("Apple Cinema");
        driver.findElement(By.cssSelector(SEARCH_BUTTON_LOCATOR)).click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://opencartt.rf.gd/index.php?route=product/search&search=Apple%20Cinema";
        Assert.assertEquals(actualUrl, expectedUrl);

        String actualProductName = driver.findElement(By.partialLinkText("Apple Cinema")).getText();
        String expectedProductName = "Apple Cinema 30\"";
        Assert.assertEquals(actualProductName, expectedProductName);
    }

    @Test
    public void testSearchMultipleProducts() {
        Helper helper = new Helper(driver);

        driver.get(URL);
        WebElement input = driver.findElement(By.cssSelector(SEARCH_INPUT_LOCATOR));
        input.clear();
        input.sendKeys("Mac");
        driver.findElement(By.cssSelector(SEARCH_BUTTON_LOCATOR)).click(); //search by keyword is done

        List<String> productsList = helper.getProductsNames();
        Assert.assertTrue(helper.checkProductsList(productsList, "Mac"));
    }
}
