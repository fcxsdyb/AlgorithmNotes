package LaiOffer.Class9_String_II;

import java.util.Arrays;

/**
 * String Question 4.4: shift the whole string to the right-hand side by two positions
 * Example: abcdef -> efabcd
 */
public class String_ShiftChar {

    public static void main(String[] args) {
        char[] array = "abcdef".toCharArray();
        shift(array, 2);
    }

    private static void shift(char[] array, int shift) {
        swap(array, 0, array.length - 1 - shift);
        swap(array, array.length - shift, array.length - 1);
        reverse(array);

        System.out.println(Arrays.toString(array));
    }

    private static void reverse(char[] array) {
        int start = 0, end = array.length - 1;

        while (start < end) {
            swapChar(array, start++, end--);
        }
    }

    private static void swap(char[] array, int start, int end) {
        while (start < end) {
            swapChar(array, start++, end--);
        }
    }

    private static void swapChar(char[] array, int slow, int fast) {
        char temp = array[slow];
        array[slow] = array[fast];
        array[fast] = temp;
    }

}
