package com.softserve.edu.tasks;

import java.util.List;

/**
 * Task 561.
 *
 */
public final class Task561Runner {
    /**
     * The default constructor.
     */
    private Task561Runner() {
    }

    /**
     * The main method, that prints list of numbers found.
     * @param args string input from command line
     */
    public static void main(final String[] args) {
        long number = new DataInput().getLongFromCommandLine();
        List<Long> numbers = new SpecificNumbersFinder()
                .getSpecificNumbers(number);
        System.out.println("All numbers which digits are included "
                + "at the end of number squared in range from 1 to  "
                + number + " are: " + numbers);
    }
}
