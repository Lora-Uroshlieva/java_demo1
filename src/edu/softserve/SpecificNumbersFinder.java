package edu.softserve;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * 561. Дано натуральное число n. Среди чисел 1, ..., n найти все
 * такие, запись которых совпадает с последними цифрами записи их
 * квадрата (как, например, 6**2  = 36, 25**2 = 625 и т. д.).
 */
public final class SpecificNumbersFinder {

    /**
     * Default constructor.
     */
    private SpecificNumbersFinder() {
    }

    /**
     * Method checks if the number matches the last digits
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
     * @param number integer
     * @return true or false
     */
    private static ArrayList getSpecificNumbers(final int number) {
        ArrayList<Integer> myArr = new ArrayList();
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
