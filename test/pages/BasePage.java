package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    public String BASE_URL = "http://opencartt.rf.gd";
    public final String SEARCH_INPUT_BY_CSS = "input.form-control.input-lg";
    public final String SEARCH_BUTTON_BY_CSS = ".btn.btn-default.btn-lg";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(BASE_URL + url);
    }

    public void search(String keyword) {
        WebElement input = this.driver.findElement(By.cssSelector(SEARCH_INPUT_BY_CSS));
        input.clear();
        input.sendKeys(keyword);
        this.driver.findElement(By.cssSelector(SEARCH_BUTTON_BY_CSS)).click();
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}
