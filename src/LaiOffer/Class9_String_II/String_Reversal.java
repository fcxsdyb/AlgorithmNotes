package LaiOffer.Class9_String_II;

import java.util.Arrays;

/**
 * String Question 4.1 4.2: String Reversal
 * Example: apple -> elppa
 */
public class String_Reversal {

    public static void main(String[] args) {
        char[] array = "apple".toCharArray();
        reversal1(array);
        reversal2(array);
    }

    /**
     * Solution 2: Recursion
     */
    private static void reversal2(char[] array) {
        recursionReverse(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void recursionReverse(char[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        swap(array, start, end);
        recursionReverse(array, ++start, --end);
    }

    /**
     * Solution 1: Iterative
     */
    private static void reversal1(char[] array) {
        if (array.length <= 1) {
            System.out.println(Arrays.toString(array));
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }

        System.out.println(Arrays.toString(array));
    }

    private static void swap(char[] array, int start, int end) {
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

}
