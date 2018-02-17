package com.softserve.edu;

import java.util.ArrayList;

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
        int number = new DataInput().getIntegerFromCommandLine();
        ArrayList<Integer> numbers = new SpecificNumbersFinder()
                .getSpecificNumbers(number);
        System.out.println("All numbers which digits are included "
                + "at the end of number squared in range from 1 to  "
                + number + " are: " + numbers);
//        System.out.println(87231*87231);
    }
}
