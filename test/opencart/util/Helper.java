package opencart.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Helper {
    private WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public List getProductsNames() {
        List<String> names = new ArrayList<>();
        List<WebElement> namesElements = driver.findElements(By.cssSelector("div.product-thumb div.caption a"));
        for (int i = 0; i<namesElements.size(); i++) {
            names.add(namesElements.get(i).getText());
        }
        return names;
    }

    public boolean checkProductsList(List<String> products, String keywords) {
        boolean isCorrect = true;
        for (String product: products) {
            if (!product.toLowerCase().contains(keywords.toLowerCase())) {
                isCorrect = false;
            }
            System.out.println(product);
        }
        return isCorrect;
    }
}
