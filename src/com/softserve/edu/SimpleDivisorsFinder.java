package com.softserve.edu;

import java.util.ArrayList;


/**
 * The class specifies all simple divisors of number given as the parameter.
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
     * @return bool - true or false
     */
    public static boolean isSimpleNumber(final int number) {
        boolean isSimple = true;
        for (int j = 2; j < Math.sqrt(number) + 1; j++) {
            if (number % j == 0) {
                isSimple = false;
                break;
            }
        }
        return isSimple;
    }

    /**
     * @param number integer number
     * @return array of simple divisors
     */
    public ArrayList<Integer> getSimpleDivisors(final int number) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if ((number % i == 0)
                    && (SimpleDivisorsFinder.isSimpleNumber(i))) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    /**
     * The main method prints all simple divisors of given number.
     * @param args integer given in command line
     */
    public static void main(final String[] args) {
        int number = new DataInput().getIntegerFromCommandLine();
        ArrayList<Integer> divisors = new SimpleDivisorsFinder()
                .getSimpleDivisors(number);

        System.out.println(divisors);
    }
}
