package LaiOffer.Class13_DynamicProgramming_I;

/**
 * DP Question 3:
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * Example:
 * index 0 1 2 3 4
 * A = [2, 3, 1, 1, 4], return true
 * B = [3, 2, 1, 0, 4], return false
 */
public class DP_JumpGame {

    public static void main(String[] args) {
        int[] array1 = {2, 3, 1, 1, 4};
        int[] array2 = {3, 2, 1, 0, 4};
        System.out.println(jump(array1));
        System.out.println(jump(array2));
    }

    private static boolean jump(int[] array) {
        int n = array.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + array[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }

}
