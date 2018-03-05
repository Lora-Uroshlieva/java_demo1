package opencart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartTest {

    private WebDriver driver;
    private final String URL = "http://www.e-shop.ga/";
    WebDriverWait myWaitVar;

    @BeforeClass
    public  void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Java/Selenium/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        myWaitVar = new WebDriverWait(driver,10);
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAddToCart() throws InterruptedException {
        driver.get(URL);

        myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='MacBook']/../../..//button[1]")));
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("div.button-group > button:nth-child(1)"));
        addToCartButtons.get(0).click();

        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success")));
        String textDisplayed = driver.findElement(By.cssSelector("div.alert.alert-success")).getText();

        Assert.assertEquals(textDisplayed.split("\n")[0], "Success: You have added MacBook to your shopping cart!");

        WebElement successButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.alert.alert-success>button")));
        successButton.click();

        myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='iPhone']/../../..//button[1]")));
        addToCartButtons.get(1).click();
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success")));

        myWaitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.alert.alert-success>button")));
        String textDisplayed2 = driver.findElement(By.cssSelector("div.alert.alert-success")).getText();

        Assert.assertEquals(textDisplayed2.split("\n")[0], "Success: You have added iPhone to your shopping cart!");

        WebElement cartButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.linkText("Shopping Cart")));
        cartButton.click();
        List<WebElement> fieldList = driver.findElements(By.cssSelector("input[name*='quantity']"));
        fieldList.get(0).clear();
        fieldList.get(0).sendKeys("2");
        driver.findElement(By.xpath("//a[text()='iPhone']/../..//button[@type='submit']")).click();
        String textDisplayed3 = driver.findElement(By.cssSelector("div.alert.alert-success")).getText();

        Assert.assertEquals(textDisplayed3.split("\n")[0], "Success: You have modified your shopping cart!");

        String total = driver.findElement(By.cssSelector("div[id='content']>div>div>table>tbody>tr+tr+tr+tr>td+td")).getText();

        Assert.assertEquals(total, "$848.40");
    }
}
