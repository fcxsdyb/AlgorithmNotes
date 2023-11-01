package LaiOffer.Class9_String_II;

import java.util.Arrays;

/**
 * String Advance 1.2: String Shuffling 2nd direction.
 * "ABCDE12345" -> "A1B2C3D4E5"
 */
public class String_Shuffling_II {

    public static void main(String[] args) {
        char[] array = "abcdef123456".toCharArray();
        shuffling(array);
    }

    private static void shuffling(char[] array) {
        convert(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void convert(char[] array, int left, int right) {
        if (left + 1 >= right) {
            return;
        }
        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;

        reverse(array, leftMid, mid - 1);
        reverse(array, mid, rightMid - 1);
        reverse(array, leftMid, rightMid - 1);

        convert(array, left, left + 2 * (leftMid - left) - 1);
        convert(array, left + 2 * (leftMid - left), right);
    }

    private static void reverse(char[] array, int left, int right) {
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    private static void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
