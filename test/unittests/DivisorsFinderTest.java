package unittests;

import com.softserve.edu.DivisorsFinder;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DivisorsFinderTest {

    @DataProvider
    public Object[][] testDataGetNaturalDivisors() {
        ArrayList<Integer> expected1 = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(4);
            add(19141);
            add(38282);
            add(76564);
        }};
        ArrayList<Integer> expected2 = new ArrayList<Integer>() {{
            add(1);
            add(5);
            add(13);
            add(25);
            add(65);
            add(325);
        }};
        return new Object[][] {
                {76564, expected1},
                {325, expected2}
        };
    }

    @DataProvider
    public Object[][] testDataGetSimpleDivisors() {
        List<Integer> expected1 = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(5);
        }};
        List<Integer> expected2 = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(5419);

        }};
        return new Object[][] {
                {45, expected1},
                {97542, expected2}};

    }

    @Test(dataProvider = "testDataGetNaturalDivisors")
    public void testGetNaturalDivisors(int number,
                                       ArrayList<Integer> expected) {
        List<Integer> actual = new DivisorsFinder()
                .getNaturalDivisors(number);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "testDataGetSimpleDivisors")
    public void testGetSimpleDivisors(int number,
                                      ArrayList<Integer> expected) {
        List<Integer> actual = new DivisorsFinder()
                .getSimpleDivisors(number);
        Assert.assertEquals(actual, expected);
    }
}
