package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;

/**
 *Task 224. We get natural number from command line
 * and need to get all the natural divisors of this number (zero remainder
 * after division).
 */
public final class Task224Runner {
    /**
     *The default constructor.
     */
    private Task224Runner() {
    }
    /**
     *The main method gets data, processes data
     * and gives array of numbers as output.
     * @param args - string params from command line
     */
    public static void main(final String[] args) {
        int number = new DataInput().getIntegerFromCommandLine();
        List<Integer> divisors = new DivisorsFinder()
                .getNaturalDivisors(number);
        System.out.println("All natural divisors of number "
                + number + ": " + divisors);
    }
}
