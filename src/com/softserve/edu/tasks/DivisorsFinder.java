package com.softserve.edu.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Class deals with different types of divisors of  number given
 * through command line.
 */
public final class DivisorsFinder {

    /**
     * The default constructor.
     */
    public DivisorsFinder() {
    }

    /**
     * Method for getting all the natural divisors of given number.
     * @param number - integer number
     * @return array of number's natural divisors
     * (division is done without modulo )
     */
    public List<Integer> getNaturalDivisors(final int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    /**
     * @param number -  integer number
     * @return array of simple divisors
     */
    public List<Integer> getSimpleDivisors(final int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if ((number % i == 0)
                    && (new NumberChecker().isSimpleNumber(i))) {
                divisors.add(i);
            }
        }
        return divisors;
    }
}
