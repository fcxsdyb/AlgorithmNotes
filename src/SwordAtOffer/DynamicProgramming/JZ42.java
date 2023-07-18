package SwordAtOffer.DynamicProgramming;

import java.lang.*;

/**
 * 剑指Offer
 * JZ42 连续子数组的最大和
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
 * 数据范围:
 * 1 <= n <= 2 x 10^5
 * −100 <= a[i] <= 100
 * 空间复杂度O(n), 时间复杂度O(n)
 * 进阶：空间复杂度O(1), 时间复杂度O(n)
 */

public class JZ42 {

    /**
     * Method 1: Brute Force.
     */
    public int FindGreatestSumOfSubArray1(int[] array) {
        int max = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            // 每开启新的循环，需要把sum归零
            sum = 0;
            for (int j = i; j < array.length; j++) {
                // 这里是求从i到j的数值和
                sum += array[j];
                // 每次比较，保存出现的最大值
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * Method 2: Dynamic Programming: Create an array, record all the max value of add new number compared to only new
     * number for going to each index of array. Return the maximum value.
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        int[] dp = new int[array.length];
        int max = array[0];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            // 动态规划，状态转移方程，确定dp[i]的最大值
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            // 每次比较，保存出现的最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * Method 3: Optimized Dynamic Programming: Only remain the max value of all time.
     */
    public int FindGreatestSumOfSubArray3(int[] array) {
        int sum = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            // 优化动态规划，确定sum的最大值
            sum = Math.max(sum + array[i], array[i]);
            // 每次比较，保存出现的最大值
            max = Math.max(max, sum);
        }
        return max;
    }


}
