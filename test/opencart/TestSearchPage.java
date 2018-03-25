package opencart;

import com.opencart.data.Categories;
import com.opencart.data.ProductsLimitOnPage;
import com.opencart.data.SortingType;
import com.opencart.pages.HomePage;
import com.opencart.pages.SearchPage;
import opencart.helpers.Listener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)

public class TestSearchPage extends BaseTest {

    @Test
    public void moveToSearchPageTest() {
        HomePage.load(driver).moveToSearchPage();
        Assert.assertEquals(driver.getCurrentUrl(),
                SearchPage.getURL());
    }

    @Test
    public void loadPageTest() throws InterruptedException {
        SearchPage.load(driver);
        String expectedUrl = SearchPage.getURL() + "&i=1";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test
    public void searchMultipleResultTest() {
        SearchPage searchPage = HomePage.load(driver).searchByKeyword("i");
        searchPage.makeExtendedSearch("i", Categories.DESCTOPS);
        int actual = searchPage.countProductsFound();
        Assert.assertEquals(actual, 15);
        Assert.assertTrue(searchPage.isTitleContainKeyword("i"));
    }

    @Test
    public void searchSingleResultTest() {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("Sony VAIO", Categories.ALL);
        int actualCount = searchPage.countProductsFound();
        Assert.assertEquals(actualCount, 1);
        String actualName = searchPage.getSearchResultsBlock().getAllProductComponentsNames().get(0);
        Assert.assertEquals(actualName, "Sony VAIO");
    }

    @Test
    public void searchByEmptyFieldTest() {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("", Categories.ALL);
        Assert.assertFalse(searchPage.getSearchResultsBlock().isProductFound());
    }

    @Test
    public void sortingByPriceAscTest() throws InterruptedException {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("mac", Categories.ALL);
        searchPage.sortProducts(SortingType.PRICE_ASC);
        Thread.sleep(4000);
        Assert.assertTrue(searchPage.isPricesSortedByAsc());
    }

    @Test
    public void sortingByPriceDescTest() {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("mac", Categories.ALL);
        searchPage.sortProducts(SortingType.PRICE_DESC);
        Assert.assertTrue(searchPage.isPricesSortedByDesc());
    }

    @Test
    public void switchingToListViewTest() {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("mac", Categories.ALL);
        searchPage.displayProductsAsList();
        Assert.assertTrue(searchPage.isProductsDisplayedByList());
    }

    @Test
    public void switchingToGridViewTest() {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("mac", Categories.ALL);
        searchPage.displayProductsAsGrid();
        Assert.assertTrue(searchPage.isProductsDisplayedByGrid());
    }

    @Test
    public void changeProductsLimitOnPageTest() {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("i", Categories.ALL);
        Assert.assertEquals(searchPage.countProductsFound(), ProductsLimitOnPage.DEFAULT_LIMIT_15.toInt());
        searchPage.changeProductsLimitOnPage(ProductsLimitOnPage.LIMIT_25);
        Assert.assertEquals(searchPage.countProductsFound(), ProductsLimitOnPage.LIMIT_25.toInt());
    }

    @Test
    public void goToNextSearchResultsPageTest() {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("i", Categories.ALL)
                .moveToNextSearchResultsPage();
        Assert.assertEquals(searchPage.countProductsFound(), ProductsLimitOnPage.DEFAULT_LIMIT_15.toInt());
        String expectedPageNumberDescription = String.format("Showing %d to %d of %d (%d Pages)", 16, 30, 32, 3);
        Assert.assertEquals(searchPage.getSearchResultsBlock().getPageNumberDescriptionText(), expectedPageNumberDescription);
    }
}
