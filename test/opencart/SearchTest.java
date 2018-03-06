package opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PageManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest {
    private WebDriver driver;
    private PageManager app;

    @BeforeClass
    public  void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/Selenium/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        options.addArguments("--headless");  //uncomment this for running without chrome UI
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        app = new PageManager(driver);
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSearchSingleProduct() {
        app.homePage.open();
        app.homePage.waitForLoad(driver);
        app.homePage.search("Apple Cinema");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://opencartt.rf.gd/index.php?route=product/search&search=Apple%20Cinema";

        Assert.assertEquals(actualUrl, expectedUrl);

        app.homePage.waitForLoad(driver);
        String actualProductName = app.searchPage.getSingleProductName("Apple Cinema");
        String expectedProductName = "Apple Cinema 30\"";

        Assert.assertEquals(actualProductName, expectedProductName);
    }

    @Test
    public void testSearchMultipleProducts() {
        app.homePage.open();
        app.homePage.search("Mac");

        app.homePage.waitForLoad(driver);
        List<String> productsList = app.searchPage.getProductsNames();
        Assert.assertTrue(app.searchPage.isProductInList(productsList, "Mac"));
    }
}
