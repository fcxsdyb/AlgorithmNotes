package LaiOffer.Class9_String_II;

import java.util.Arrays;
import java.util.HashSet;

/**
 * String Advance 2: Have duplicate letters in input string.
 * Example: "abbbc"
 */
public class String_Permutation {
    static int count = 0;

    public static void main(String[] args) {
        char[] array = "abbbc".toCharArray();
        permutationDup(array, 0);
    }

    private static void permutationDup(char[] array, int index) {
        if (index == array.length) {
            System.out.println(Arrays.toString(array));
            System.out.println(++count);
            return;
        }

        HashSet<Character> setDedup = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (!setDedup.contains(array[i])) {
                setDedup.add(array[i]);
                swap(array, index, i);
                permutationDup(array, index + 1);
                swap(array, index, i);
            }
        }
    }

    private static void swap(char[] array, int i1, int i2) {
        char temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

}
