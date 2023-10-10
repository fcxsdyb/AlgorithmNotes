package LaiOffer.Class7_Midterm;

import java.util.Arrays;

/**
 * Question 3. Given a string without duplicate letters, how to print out all permutations of the string.
 * input = "abc" -> "abc", "acb", "bac", "bca", "cab", "cba"
 * Assume the input is not null or "".
 * <p>
 * Time Complexity = O(n!)
 * Space Complexity = O(n)
 */
public class PermutationWithoutDuplicateLetters {

    public static void permutation(char[] input, int index) {
        if (index == input.length) {
            System.out.println(Arrays.toString(input));
            return;
        }

        for (int i = index; i < input.length; i++) {
            swap(input, index, i);
            permutation(input, index + 1);
            swap(input, index, i);
        }
    }

    private static void swap(char[] input, int index, int i) {
        char temp = input[i];
        input[i] = input[index];
        input[index] = temp;
    }

    public static void main(String[] args) {
        String input = "abcd";
        char[] inputChar = input.toCharArray();
        permutation(inputChar, 0);
    }

}
