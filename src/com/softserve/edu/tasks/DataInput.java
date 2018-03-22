package com.softserve.edu.tasks;

import java.util.Scanner;

/**
 * Class is intended to get new data from command line.
 */
public class DataInput {
    /**
     * Scanner instance.
     */
    private final Scanner input = new Scanner(System.in);

    /**
     * Method is intended to get new integer number from command line.
     * @return integer number given through command line
     */
    public int getIntegerFromCommandLine() {
        System.out.println("Enter the natural number: ");
        return input.nextInt();
    }

    /**
     * Method is intended to get new long number from command line.
     * @return long integer number
     */
    public long getLongFromCommandLine() {
        System.out.println("Enter the natural number: ");
        return input.nextLong();
    }
}
