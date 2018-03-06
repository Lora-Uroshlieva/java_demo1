package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    private final String URL = "/index.php?route=product/search";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        super.open(URL);
    }

    public String getSingleProductName(String keyword) {
        WebElement product = this.driver.findElement(By.partialLinkText(keyword));
        return product.getText();
    }

    public List<String> getProductsNames() {
        List<String> names = new ArrayList<>();

//        System.out.println(driver.findElements(By.cssSelector("div.product-thumb div.caption a")));
        List<WebElement> namesElements = this.driver.findElements(By.cssSelector("div.product-thumb div.caption a"));
        for (int i = 0; i<namesElements.size(); i++) {
            names.add(namesElements.get(i).getText());
        }
        return names;
    }

    public boolean isProductInList(List<String> products, String keywords) {
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
