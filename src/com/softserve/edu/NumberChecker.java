package com.softserve.edu;

/**
 * Class deals with checking if number satisfies specific criteria.
 */
public class NumberChecker {
    /**
     * Method checks if the given number is simple or not.
     * @param number integer
     * @return bool - true or false
     */
    public boolean isSimpleNumber(final int number) {
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
     * Method checks if the number matches the last digits.
     * of the number squared (n*n).
     * @param number integer
     * @return boolean
     */
    public boolean isNumberIncludedInSquaredNumber(final int number) {
        int pow = number * number;
        String numberToString = String.valueOf(number);
        String powToString = String.valueOf(pow);
        return powToString.endsWith(numberToString);
    }
}
