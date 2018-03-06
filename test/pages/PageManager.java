package pages;

import org.openqa.selenium.WebDriver;

public class PageManager {
    public HomePage homePage;
    public SearchPage searchPage;
    public PageManager(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.searchPage = new SearchPage(driver);
    }
}
