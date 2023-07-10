package DynamicProgramming;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ85 连续子数组的最大和(二)
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，找到一个具有最大和的连续子数组。
 * 1.子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * 2.如果存在多个最大和的连续子数组，那么返回其中长度最长的，该题数据保证这个最长的只存在一个
 * 3.该题定义的子数组的最小长度为1，不存在为空的子数组，即不存在[]是某个数组的子数组
 * 4.返回的数组不计入空间复杂度计算
 * 数据范围:
 * 1 <= n <= 10^5
 * −100 <= a[i] <= 100
 * 空间复杂度O(n), 时间复杂度O(n)
 * 进阶：空间复杂度O(1), 时间复杂度O(n)
 */

public class JZ85 {

    /**
     * Method 1: Dynamic Programming: Based on the logic in JZ42, using an array to record the longest array for the max
     * value.
     */
    public int[] FindGreatestSumOfSubArray1(int[] array) {
        //记录到下标i为止的最大连续子数组和
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int maxsum = dp[0];
        //滑动区间
        int left = 0, right = 0;
        //记录最长的区间
        int resl = 0, resr = 0;
        for (int i = 1; i < array.length; i++) {
            right++;
            //状态转移：连续子数组和最大值
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            //区间新起点
            if (dp[i - 1] + array[i] < array[i])
                left = right;
            //更新最大值
            if (dp[i] > maxsum || dp[i] == maxsum && (right - left + 1) > (resr - resl + 1)) {
                maxsum = dp[i];
                resl = left;
                resr = right;
            }
        }
        //取数组
        int[] res = new int[resr - resl + 1];
        for (int i = resl; i <= resr; i++)
            res[i - resl] = array[i];
        return res;
    }

    /**
     * Method 2: Optimized Dynamic Programming.
     */
    public int[] FindGreatestSumOfSubArray2(int[] array) {
        int x = array[0];
        int y = 0;
        int maxsum = x;
        //滑动区间
        int left = 0, right = 0;
        //记录最长的区间
        int resl = 0, resr = 0;
        for (int i = 1; i < array.length; i++) {
            right++;
            //状态转移：连续子数组和最大值
            y = Math.max(x + array[i], array[i]);
            //区间新起点
            if (x + array[i] < array[i])
                left = right;
            //更新最大值
            if (y > maxsum || y == maxsum && (right - left + 1) > (resr - resl + 1)) {
                maxsum = y;
                resl = left;
                resr = right;
            }
            //更新x的状态
            x = y;
        }
        //取数组
        int[] res = new int[resr - resl + 1];
        for (int i = resl; i <= resr; i++)
            res[i - resl] = array[i];
        return res;
    }

}
