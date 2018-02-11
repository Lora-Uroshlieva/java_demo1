package edu.softserve;

import java.util.Scanner;
import java.util.ArrayList;


/**
 * Task #325.
 * The class specifies all simple divisors of number given as parameter
 */
public final class SimpleDivisorsFinder {
    /**
     * The default constructor.
     */
    private SimpleDivisorsFinder() {
    }

    /**
     * Method checks if the given number is simple or not.
     * @param number integer
     * @return bool
     */
    private static boolean isSimpleNumber(final int number) {
        boolean isSimple = true;
        for (int j = 2; j < number; j++) {
            if (number % j == 0) {
                isSimple = false;
                break;
            }
        }
        return isSimple;
    }

    /**
     * The main method prints all simple divisors of given number.
     * @param args integer given in command line
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the natural number for getting all"
                + " the simple divisors: ");
        int number = input.nextInt();
        int i = 1;
        ArrayList<Integer> divisors = new ArrayList<>();
        while (i <= number) {
            if (number % i == 0 && SimpleDivisorsFinder.isSimpleNumber(i)) {
                divisors.add(i);
            }
            i++;
        }
        System.out.println(divisors);
    }
}
