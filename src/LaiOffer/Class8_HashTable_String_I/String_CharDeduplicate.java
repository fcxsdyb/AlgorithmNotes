package LaiOffer.Class8_HashTable_String_I;

import java.util.Arrays;

/**
 * String Question 2.1:
 * Remove duplicated and adjacent letters (leave only one letter in each duplicated section) in a string.
 * Example: String input = "aaaabbbb_____ccc" -> output: "ab_c"
 */
public class String_CharDeduplicate {

    public static void main(String[] args) {
        char[] array = "aaaabbbb_____ccc".toCharArray();
        deduplicate(array);
    }

    private static void deduplicate(char[] array) {
        if (array.length < 2) {
            System.out.println(Arrays.toString(array));
            return;
        }

        int slow = 0;
        int fast = 1;

        while (fast < array.length) {
            if (array[slow] != array[fast]) {
                array[++slow] = array[fast++];
            } else {
                fast++;
            }
        }

        System.out.println(new String(array, 0, slow + 1));
    }

}
