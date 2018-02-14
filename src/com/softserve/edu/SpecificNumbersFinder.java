package com.softserve.edu;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class gets natural number from command line and prints all numbers
 * from 1 to number, which digits are included as last digits
 * of number pow to square.
 */
public final class SpecificNumbersFinder {

    /**
     * Default constructor.
     */
    private SpecificNumbersFinder() {
    }

    /**
     * Method checks if the number matches the last digits.
     * of the number multiplied to number (n*n).
     * @param number integer
     * @return boolean
     */
    private static boolean isNumberIncludedInPow(final int number) {
        int pow = number * number;
        String numberToString = String.valueOf(number);
        String powToString = String.valueOf(pow);
        return powToString.endsWith(numberToString);
    }

    /**
     * Method returns array of numbers, which digits are included as last digits
     * of number pow to square.
     * @param number integer
     * @return array of numbers, which digits are included as last digits
     * of number pow to square
     */
    private static ArrayList getSpecificNumbers(final int number) {
        ArrayList<Integer> myArr = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (isNumberIncludedInPow(i)) {
                myArr.add(i);
            }
        }
        return myArr;
    }

    /**
     * The main method, that prints list of numbers found.
     * @param args string input from command line
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the natural number to get all the numbers"
                + " from 1 to given number, that matches with last digits"
                + " of their pow to square ");
        int number = input.nextInt();
        System.out.println(getSpecificNumbers(number));
    }
}
