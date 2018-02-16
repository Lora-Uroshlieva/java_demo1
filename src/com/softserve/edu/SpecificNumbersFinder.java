package com.softserve.edu;
import java.util.ArrayList;

/**
 * Class gets natural number,
 * iterates through all numbers from 1 to number,
 * and returns array of numbers which digits are included
 * as the last digits of the number squared.
 */
@SuppressWarnings("WeakerAccess")
public final class SpecificNumbersFinder {

    /**
     * Default constructor.
     */
    public SpecificNumbersFinder() {
    }

    /**
     * Method returns array of numbers, which digits are included as last digits
     * of number pow to square.
     * @param number integer
     * @return array of numbers, which digits are included as last digits
     * of number squared.
     */
    public ArrayList<Integer> getSpecificNumbers(final int number) {
        ArrayList<Integer> myArr = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (new NumberChecker().isNumberIncludedInSquaredNumber(i)) {
                myArr.add(i);
            }
        }
        return myArr;
    }
}
