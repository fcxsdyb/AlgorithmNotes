package Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ14 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长的 m 段（m 、 n 都是整数， n > 1 并且 m > 1 ， m <= n），每段绳子的长度记为 k[1],...,k[m]
 * 请问 k[1]*k[2]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18
 * 2 <= n <= 60
 * 空间复杂度O(1), 时间复杂度O(n)
 */

public class JZ14 {

    /**
     * Method 1: Dynamic Programming.
     */
    public int cutRope1(int target) {
        //不超过3直接计算
        if (target <= 3)
            return target - 1;
        //dp[i]表示长度为i的绳子可以被剪出来的最大乘积
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        //遍历后续每一个长度
        for (int i = 4; i <= target; i++)
            //可以被分成两份
            for (int j = 1; j < i; j++)
                //取最大值
                dp[i] = Math.max(dp[i], j * dp[i - j]);
        return dp[target];
    }

    /**
     * Method 2: Greedy Algorithm. Based on Inequality of arithmetic and geometric means, and after analysis, when x = 3
     * the result will be the maximum.
     */
    public int cutRope2(int target) {
        //不超过3直接计算
        if (target <= 3)
            return target - 1;
        int res = 1;
        while (target > 4) {
            //连续乘3
            res *= 3;
            target -= 3;
        }
        return res * target;
    }

}
