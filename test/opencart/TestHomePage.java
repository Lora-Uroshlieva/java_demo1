package opencart;

import com.opencart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage extends BaseTest {

    @Test
    public void testSearch() {
        HomePage homePage = HomePage.load(driver);
        homePage.searchByKeyword("mac");
        Assert.assertEquals(driver.getCurrentUrl(),
                "http://opencartt.rf.gd/index.php?route=product/search&search=mac");
    }
}
