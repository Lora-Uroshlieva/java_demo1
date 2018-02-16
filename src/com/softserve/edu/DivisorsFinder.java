package com.softserve.edu;

import java.util.ArrayList;

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
    public ArrayList<Integer> getNaturalDivisors(final int number) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    /**
     * @param number integer number
     * @return array of simple divisors
     */
    public ArrayList<Integer> getSimpleDivisors(final int number) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if ((number % i == 0)
                    && (new NumberChecker().isSimpleNumber(i))) {
                divisors.add(i);
            }
        }
        return divisors;
    }
}
