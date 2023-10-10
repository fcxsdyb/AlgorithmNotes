package LaiOffer.Class8_HashTable_String_I;

import java.util.Arrays;

/**
 * String Question 2.2:
 * Remove duplicated and adjacent letters repeatedly.
 * Example: String input = "abbbbaz" -> "aaz" -> output: "z"
 * <p>
 * Solution 1: Using stack. (Cost more space)
 * Solution 2: Using two pointers.
 */
public class String_DeduplicateRepeat {

    public static void main(String[] args) {
        char[] array = "azbbbzs".toCharArray();
        deduplicateRepeat(array);
    }

    private static void deduplicateRepeat(char[] array) {
        if (array.length <= 1) {
            System.out.println(Arrays.toString(array));
        }

        int slow = 0;
        int fast = 1;

        while (true) {
            if (slow == -1) {
                if (fast < array.length) {
                    array[0] = array[fast];
                    slow = 0;
                    fast++;
                } else {
                    break;
                }
            }

            if (fast == array.length) {
                break;
            }

            if (array[slow] == array[fast]) {
                while (fast < array.length && array[slow] == array[fast]) {
                    fast++;
                }
                slow--;
            } else {
                char temp = array[fast];
                slow++;
                fast++;
                array[slow] = temp;
            }
        }

        if (slow == -1) {
            System.out.println("");
        } else {
            System.out.println(new String(array, 0, slow + 1));
        }
    }

}
