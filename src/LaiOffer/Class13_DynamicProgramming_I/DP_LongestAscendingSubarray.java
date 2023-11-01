package LaiOffer.Class13_DynamicProgramming_I;

/**
 * DP Question 1: Longest Ascending Subarray
 * Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
 * For example: If the input array is {7, 2, 3, 1, 5, 8, 9, 6}, the subarray with the most numbers in ascending order
 * is {1. 5, 8, 9} and the expected output is 4.
 * <p>
 * Concept:
 * Sub-array: contiguous elements in an array
 * Sub-sequence: not necessarily contiguous. (can jump). e.g. 2 5 6
 * <p>
 * 1. Base case M[0] = 1, because there is only one element as the based case
 * 2. Induction rule: M[i] represents [from the 0-th element to the i-th element],
 * the value of the longest ascending subarray, (including the i-th element)
 * <p>
 * M[i] = M［i-1］+ 1     if input[i-1] < input[i]
 * 1               else
 * <p>
 * Solution
 * input = {7, 2, 3, 1, 5, 8, 9, 6}
 * M[i]  =  1  1  2  1  2  3  4  1
 * int global_max = 4
 */
public class DP_LongestAscendingSubarray {

    public static void main(String[] args) {
        int[] array = {7, 2, 3, 1, 5, 8, 9, 6};
        System.out.println(LAS(array));
    }

    private static int LAS(int[] array) {
        int max = 0;
        int[] dp = new int[array.length];
        dp[0] = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(dp[i], max);
            } else {
                dp[i] = 1;
            }
        }

        return max;
    }

}
