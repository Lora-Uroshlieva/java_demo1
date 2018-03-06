package unittests;

import com.softserve.edu.SpecificNumbersFinder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SpecificNumbersFinderTest {
    @DataProvider
    public Object[][] testDataGetSpecificNumbers() {
        List<Long> expected = new ArrayList<>();
        expected.add(1L);
        expected.add(5L);
        expected.add(6L);
        expected.add(25L);
        expected.add(76L);
        expected.add(376L);
        expected.add(625L);
        expected.add(9376L);
        return new Object[][] {{10000, expected}};
    }

    @Test(dataProvider = "testDataGetSpecificNumbers")
    public void testGetSpecificNumbers(int number, ArrayList expected) {
        List actual = new  SpecificNumbersFinder().getSpecificNumbers(number);
        Assert.assertEquals(expected, actual);
    }
}
