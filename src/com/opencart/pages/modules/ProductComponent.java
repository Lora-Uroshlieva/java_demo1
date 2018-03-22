package com.opencart.pages.modules;

import com.opencart.pages.utils.ConciseAPI;
import com.opencart.pages.utils.RegexUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductComponent extends ConciseAPI {
    private WebElement productLayout;
    private WebDriverWait myWait;
    private final String NAME_BY_CSS = "h4 a";
    private final String DESCRIPTION_BY_CSS = ".caption > p:nth-child(2)";
    private final String PRICE_BY_CSS = ".caption .price";
    private final String ADD_TO_CART_BY_CSS = ".fa.fa-shopping-cart";
    private final String ADD_TO_WISH_BY_CSS = ".fa.fa-heart";
    private final String COMPARE_BY_CSS = ".fa.fa-exchange";

    public ProductComponent(WebDriver driver, WebElement productLayout) {
        super(driver);
        this.productLayout = productLayout;
        verifyWebElements();
    }

    private void verifyWebElements() {
        getName();
        getPrice();
        getDescription();
        getAddToCart();
        getAddToWish();
        getCompare();
    }

    public WebElement getName() {
        return findElementInLayoutByCss(productLayout, NAME_BY_CSS);
    }

    public String getNameText() {
        return getName().getText();
    }

    public void clickName() {
        getName().click();
    }

    public WebElement getPrice() {
        return findElementInLayoutByCss(productLayout, PRICE_BY_CSS);
    }

    public double getPriceAmount() {
        return RegexUtils.extractFirstDouble(getPrice().getText());
    }

    public WebElement getDescription() {
        return findElementInLayoutByCss(productLayout, DESCRIPTION_BY_CSS);
    }

    public String getDescriptionText() {
        return findElementInLayoutByCss(productLayout, DESCRIPTION_BY_CSS).getText();
    }

    public WebElement getAddToCart() {
        return findElementInLayoutByCss(productLayout, ADD_TO_CART_BY_CSS);
    }

    public void clickAddToCart() {
        getAddToCart().click();
    }

    public WebElement getAddToWish() {
        return findElementInLayoutByCss(productLayout, ADD_TO_WISH_BY_CSS);
    }

    public void clickAddToWish() {
        getAddToWish().click();
    }

    public WebElement getCompare() {
        return findElementInLayoutByCss(productLayout, COMPARE_BY_CSS);
    }

    public void clickCompare() {
        getCompare().click();
    }

    public String getElementClasses() {
        return productLayout.getAttribute("class");
    }
}