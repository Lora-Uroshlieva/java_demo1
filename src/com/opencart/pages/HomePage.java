package com.opencart.pages;

import com.opencart.pages.modules.Header;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;
    protected Header header;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.header = new Header(driver);
    }

        public static HomePage load(WebDriver driver) {
        driver.get("http://opencartt.rf.gd/");
        return new HomePage(driver);
    }

    //TODO write business logic
    public HomePage selectCurrency(String currency) {
        header.clickCurrency();
        return new HomePage(driver);
    }

    //TODO - must return new search page
    public void searchByKeyword(String keyword) {
        header.clearSearchField();
        header.sendTextToSearchField(keyword);
        header.clickSearchButton();
    }

}
