package LaiOffer.Class9_String_II;

import java.util.Arrays;

/**
 * String Question 4.3: String Reversal
 * Example: I love yahoo -> yahoo love I
 */
public class String_ReversalWords {

    public static void main(String[] args) {
        char[] array = " I love  ".toCharArray();
        reverseWords(array);
    }

    private static void reverseWords(char[] array) {
        int slow = 0;
        int fast = 0;

        while (true) {
            if (fast == array.length) {
                if (slow != fast - 1 && array[slow] != ' ') {
                    swap(array, slow, fast - 1);
                }
                break;
            }

            if (array[fast] != ' ') {
                fast++;
            } else {
                swap(array, slow, fast - 1);
                fast++;
                if (fast < array.length) {
                    slow = fast;
                } else {
                    slow = fast - 1;
                }
            }
        }

        reverse(array);

        System.out.println(Arrays.toString(array));
    }

    private static void reverse(char[] array) {
        int start = 0, end = array.length - 1;
        while (start < end) {
            swapChar(array, start++, end--);
        }
    }

    private static void swap(char[] array, int slow, int fast) {
        while (slow < fast) {
            swapChar(array, slow, fast);
            slow++;
            fast--;
        }
    }

    private static void swapChar(char[] array, int slow, int fast) {
        char temp = array[slow];
        array[slow] = array[fast];
        array[fast] = temp;
    }

}
