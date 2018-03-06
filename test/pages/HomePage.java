package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;
    public String URL = "/index.php?route=common/home";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        super.open(URL);
    }
}
