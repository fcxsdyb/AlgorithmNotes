package LaiOffer.Class6_GraphSearchAlgorithms_II;

import java.util.Arrays;

/**
 * DFS Question 3: Given a string with no duplicated letters, how to print out all permutations of the string.
 * input = "abc" -> "abc", "acb", "bac", "bca", "cab", "cba"
 * Assume the input is not null or "".
 * <p>
 * Time Complexity = O(n!)
 * Space Complexity = O(n)
 */
public class DFS_PermutationLetters {

    public static void main(String[] args) {
        String input = "abcd";
        char[] array = input.toCharArray();
        printPermutation(array, 0);
    }

    private static void printPermutation(char[] array, int index) {
        if (index == array.length) {
            System.out.println(Arrays.toString(array));
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            printPermutation(array, index + 1);
            swap(array, index, i);
        }
    }

    private static void swap(char[] array, int index, int i) {
        char temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }

}
