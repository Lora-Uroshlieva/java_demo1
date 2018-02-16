package com.softserve.edu;

import java.util.Scanner;

/**
 * Class is intended to get new data from command line.
 */
public class DataInput {

    /**
     * Method is intended to get new integer number from command line.
     * @return integer number given through command line
     */
    public int getIntegerFromCommandLine() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the natural number: ");
        return input.nextInt();
    }
}
