import com.softserve.edu.SpecificNumbersFinder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class SpecificNumbersFinderTest {
    @DataProvider
    public Object[][] testDataGetSpecificNumbers() {
        List expected = new ArrayList<Integer>() {{
            add(1);
            add(5);
            add(6);
            add(25);
            add(76);
            add(376);
            add(625);
            add(9376);
        }};
        return new Object[][] {{10000, expected}};
    }

    @Test(dataProvider = "testDataGetSpecificNumbers")
    public void testGetSpecificNumbers(int number, ArrayList expected) {
        List actual = new  SpecificNumbersFinder().getSpecificNumbers(number);
        Assert.assertEquals(expected, actual);
    }
}
