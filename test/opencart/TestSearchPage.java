package opencart;

import com.opencart.data.Categories;
import com.opencart.data.SortingType;
import com.opencart.pages.HomePage;
import com.opencart.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(actual, 11);
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
    public void testSortingByPriceAsc() throws InterruptedException {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("mac", Categories.ALL);
        searchPage.sortProducts(SortingType.PRICE_ASC);
        Thread.sleep(4000);
        Assert.assertTrue(searchPage.isPricesSortedByAsc());
    }

    @Test
    public void testSortingByPriceDesc() {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("mac", Categories.ALL);
        searchPage.sortProducts(SortingType.PRICE_DESC);
        Assert.assertTrue(searchPage.isPricesSortedByDesc());
    }

    @Test
    public void testSwitchingToListView() {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("mac", Categories.ALL);
        searchPage.displayProductsAsList();
        Assert.assertTrue(searchPage.isProductsDisplayedByList());
    }

    @Test
    public void testSwitchingToGridView() {
        SearchPage searchPage = SearchPage.load(driver)
                .makeExtendedSearch("mac", Categories.ALL);
        searchPage.displayProductsAsGrid();
        Assert.assertTrue(searchPage.isProductsDisplayedByGrid());
    }
}
