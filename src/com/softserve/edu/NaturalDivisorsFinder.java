package com.softserve.edu;

import java.util.ArrayList;


/**
 * Class prints all the natural divisors of  number given through command line.
 */
public final class NaturalDivisorsFinder {

    /**
     * The default constructor.
     */
    private NaturalDivisorsFinder() {
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
     * The main method prints list of natural divisors of given number.
     * @param args integer number
     */
    public static void main(final String[] args) {
        int number = new DataInput().getIntegerFromCommandLine();
        ArrayList<Integer> divisors = new NaturalDivisorsFinder()
                .getNaturalDivisors(number);
        System.out.println("All natural divisors of number "
                + number + ": " + divisors);
    }
}
