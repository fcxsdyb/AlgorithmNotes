package LeetCodeHot100;

/**
 * 53.最大子数组和
 */

public class Q24 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

}
