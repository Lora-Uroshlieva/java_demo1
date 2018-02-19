import com.softserve.edu.NumberChecker;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NumberCheckerTest {
    @DataProvider
    public Object[][] testDataIsSimple() {
        return new Object[][]{
                {937, true},
                {17, true},
                {16, false},
                {17852, false}
        };
    }

    @DataProvider
    public Object[][] testDataIsNumberIncludedInSquaredNumber() {
        return new Object[][]{
                {6, true},
                {625, true},
                {14, false},
                {17852, false}
        };
    }

    @Test(dataProvider = "testDataIsSimple")
    public void isSimpleNumber(int number, boolean expected) {
        boolean actual = new NumberChecker().isSimpleNumber(number);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "testDataIsNumberIncludedInSquaredNumber")
    public void isNumberIncludedInSquaredNumber(int number, boolean expected) {
        boolean actual = new NumberChecker().isNumberIncludedInSquaredNumber(number);
        Assert.assertEquals(actual, expected);
    }
}
