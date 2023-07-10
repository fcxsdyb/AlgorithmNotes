package DynamicProgramming;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ71 跳台阶扩展问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级
 * 求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法
 * 1 <= n <= 20
 * 空间复杂度O(1), 时间复杂度O(1)
 */

public class JZ71 {

    /**
     * Method 1: Dynamic Programming.
     */
    public int jumpFloorII1(int target) {
        int[] dp = new int[target + 1];
        //初始化前面两个
        dp[0] = 1;
        dp[1] = 1;
        //依次乘2
        for (int i = 2; i <= target; i++)
            dp[i] = 2 * dp[i - 1];
        return dp[target];
    }

    /**
     * Method 2: Recursion.
     */
    public int jumpFloorII2(int target) {
        //1或0都是1种
        if (target <= 1)
            return 1;
        return 2 * jumpFloorII2(target - 1);
    }

}
