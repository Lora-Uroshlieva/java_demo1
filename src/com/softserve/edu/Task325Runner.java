package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;

/**
 *Task 325. We get natural number from command line
 * and need to get all the simple divisors of this number (zero remainder
 * after division).
 * Simple number is a number which can be divided only by 1 and number.
 */
public final class Task325Runner {
    /**
     * The default constructor.
     */
    private Task325Runner() {
    }
    /**
     * The main method prints all simple divisors of given number.
     * @param args integer given in command line
     */
    public static void main(final String[] args) {
        int number = new DataInput().getIntegerFromCommandLine();
        List<Integer> divisors = new DivisorsFinder()
                .getSimpleDivisors(number);
        System.out.println("All simple divisors of number "
                + number + ": " + divisors);
    }
}
