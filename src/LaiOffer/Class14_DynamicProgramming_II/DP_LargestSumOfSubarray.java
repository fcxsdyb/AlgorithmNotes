package LaiOffer.Class14_DynamicProgramming_II;

/**
 * DP question 1: Largest sum of a subarray
 * Given an unsorted array, find the subarray that has the greatest sum. Return the sum.
 * For example:
 * If the input array is {1, 2, 4, -1, -2, 10, -1}, the greatest sum is achieved by subarray {1, 2, 4, -1, -2, -10}.
 */
public class DP_LargestSumOfSubarray {

    /**
     * Solution:
     * 1. Base case: M[0] = input[0] // only 1 element in the input
     * 2. Induction rule: M[i] represents [from the 0-th element to the i-th element] the largest sum of a subarray,
     * including the i-th element.
     * <p>
     * M[i] = M[i - 1] + input[i]     if M[i - 1] >= 0
     * input[i]                if M[i - 1] < 0
     * e.g.
     * input[N] = {1, 2, 4, -1, -2, 10, -1},
     * M[i]     =  1  3  7   6   4  14  13
     * int global_max_sol = 14
     * <p>
     * input[N] = {1, 2, 4, -1, -20, 10, -1},
     * M[i]     =  1  3  7   6  -14  10   9
     * int global_max_sol = 10
     * <p>
     * Follow up 1: what if we want to optimize the space complexity?
     * Solution: That is easy, just replace M[i] array with a variable, named int previous_value
     * <p>
     * Follow up 2: what if we want to return the start and end indices of the solution array.
     * Solution: Use four index: start, end, sol_start, sol_end to record the indices
     */

    public static void main(String[] args) {
        int[] array = {1, 2, 4, -1, -20, 10, -1};

        int[] result1 = largestSumOfSubarray1(array);
        System.out.println("Maximum contiguous sum is: " + result1[0]);
        System.out.println("Starting index: " + result1[1]);
        System.out.println("Ending index: " + result1[2]);

        int[] result2 = largestSumOfSubarray2(array);
        System.out.println("Maximum contiguous sum is: " + result2[0]);
        System.out.println("Starting index: " + result2[1]);
        System.out.println("Ending index: " + result2[2]);
    }

    /**
     * Normal DP
     */
    private static int[] largestSumOfSubarray2(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = arr[0];
        int maxSum = dp[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;  // temporary start index

        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + arr[i];
            } else {
                dp[i] = arr[i];
                tempStart = i;
            }

            if (dp[i] > maxSum) {
                maxSum = dp[i];
                start = tempStart;
                end = i;
            }
        }

        return new int[]{maxSum, start, end};
    }

    /**
     * Kadane's algorithm
     */
    private static int[] largestSumOfSubarray1(int[] array) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int start = 0;
        int end = 0;
        int s = 0;  // Temporary starting point

        for (int i = 0; i < array.length; i++) {
            max_ending_here += array[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }

        return new int[]{max_so_far, start, end};
    }


}
