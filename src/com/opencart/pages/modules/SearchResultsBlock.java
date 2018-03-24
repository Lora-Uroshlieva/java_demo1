package com.opencart.pages.modules;

import com.opencart.data.Categories;
import com.opencart.data.ProductsLimitOnPage;
import com.opencart.data.SortingType;
import com.opencart.pages.utils.RegexUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsBlock extends FeaturedBlock {
    public SearchResultsBlock(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductCompareLink() {
        return waitElementVisibleByCss("#compare-total");
    }

    public String getProductCompareLinkText() {
        return getProductCompareLink().getText();
    }

    public int getProductComparisonAmount() {
        return RegexUtils.extractFirstNumber(getProductCompareLinkText());
    }

    public void clickListViewButton() {
        driver.findElement(By.id("list-view")).click();
    }

    public void clickGridViewButton() {
        driver.findElement(By.id("grid-view")).click();
    }

    public void selectSortingType(SortingType sortingType) {
        Select dropdown = new Select(driver.findElement(By.id("input-sort")));
        dropdown.selectByVisibleText(sortingType.toString());
    }

    public void selectQuantityOnPage(ProductsLimitOnPage quantity) {
        Select dropdown = new Select(driver.findElement(By.id("input-limit")));
        dropdown.selectByVisibleText(quantity.toString());
    }
}
