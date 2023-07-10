package DynamicProgramming;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ63 买卖股票的最好时机(一)
 * 假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
 * 1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天
 * 2.如果不能获取到任何利润，请返回0
 * 3.假设买入卖出均无手续费
 * 0 <= n <= 10^5, 0 <= val <= 10^4
 * 空间复杂度O(1), 时间复杂度O(n)
 */

public class JZ63 {

    /**
     * Method 1: Dynamic Programming.
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        //dp[i][0]表示某一天不持股到该天为止的最大收益，dp[i][1]表示某天持股，到该天为止的最大收益
        int[][] dp = new int[n][2];
        //第一天不持股，总收益为0
        dp[0][0] = 0;
        //第一天持股，总收益为减去该天的股价
        dp[0][1] = -prices[0];
        //遍历后续每天，状态转移
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        //最后一天不持股，到该天为止的最大收益
        return dp[n - 1][0];
    }

    /**
     * Method 2: Greedy Algorithm.
     */
    public int maxProfit2(int[] prices) {
        //维护最大收益
        int res = 0;
        //排除特殊情况
        if (prices.length == 0)
            return res;
        //维护最低股票价格
        int Min = prices[0];
        //遍历后续股票价格
        for (int i = 1; i < prices.length; i++) {
            //如果当日价格更低则更新最低价格
            Min = Math.min(Min, prices[i]);
            //维护最大值
            res = Math.max(res, prices[i] - Min);
        }
        return res;
    }

}
