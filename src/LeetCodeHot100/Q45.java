package LeetCodeHot100;

/**
 * 121.买卖股票的最佳时机
 */

public class Q45 {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[prices.length - 1];
    }

}
