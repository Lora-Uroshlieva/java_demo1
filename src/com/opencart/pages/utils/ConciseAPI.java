package com.opencart.pages.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConciseAPI {
    public WebDriver driver;
    private WebDriverWait myWait;

    public ConciseAPI(WebDriver driver) {
        this.driver = driver;
        this.myWait = new WebDriverWait(this.driver, 5);
    }

    public WebElement waitElementVisibleByCss(String cssSelector) {
        return myWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    //TODO write method for search group of elements and wait visibility
//    public List<WebElement> waitElementsVisibleByClassName(String className) {
//        return myWait.until(ExpectedConditions
//                .visibilityOfAllElementsLocatedBy(By.className(className)));
//    }

    public WebElement findElementInLayoutByCss(WebElement layoutElement, String cssSelector) {
        return myWait.until(ExpectedConditions.visibilityOf(layoutElement
                .findElement(By.cssSelector(cssSelector))));
    }

}
