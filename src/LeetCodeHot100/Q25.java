package LeetCodeHot100;

/**
 * 55.跳跃游戏
 */

public class Q25 {

    /**
     * 1.DP
     */
    public boolean canJump1(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] != true) continue;
            int steps = nums[i];
            for (int j = 1; j <= steps; j++) {
                if (i + j >= nums.length) break;
                dp[i + j] = true;
            }
        }
        return dp[nums.length - 1];
    }

    /**
     * 2.Greedy Algorithm
     */
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= right) {
                right = Math.max(right, i + nums[i]);
                if (right >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
