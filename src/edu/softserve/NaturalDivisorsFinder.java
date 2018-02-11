package edu.softserve;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class prints all the natural divisors of given number.
 */
public final class NaturalDivisorsFinder {
    /**
     * The default constructor.
     */
    private NaturalDivisorsFinder() {
    }

    /**
     * The main method prints list of natural divisors of given number.
     * @param args integer number
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the natural number to get all "
                + "the natural divisors: ");
        int number = input.nextInt();
        int i = 1;
        ArrayList<Integer> divisors = new ArrayList<>();
        while (i <= number) {
            if (number % i == 0) {
                divisors.add(i);
            }
            i++;
        }
        System.out.println("All natural divisors of number "
                + number + ": " + divisors);
    }
}
