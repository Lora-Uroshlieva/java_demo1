package com.opencart.pages.modules;

import com.opencart.pages.utils.ConciseAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FeaturedBlock extends ConciseAPI {
    protected WebDriver driver;
    protected List<ProductComponent> productComponents;
    private final String PRODUCT_LAYOUT_BY_CSS = ".product-layout";

    public FeaturedBlock(WebDriver driver) {
        super(driver);
        initProductComponents();
    }

    public void initProductComponents() {
        productComponents = new ArrayList<ProductComponent>();
        for (WebElement currentElement: waitAllElementsVisibleByCss(PRODUCT_LAYOUT_BY_CSS)) {
            productComponents.add(new ProductComponent(driver, currentElement));
        }
    }

    public List<ProductComponent> getProductComponents() {
        initProductComponents();
        return productComponents;
    }
}
