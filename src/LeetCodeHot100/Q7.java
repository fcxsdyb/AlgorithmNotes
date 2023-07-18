package LeetCodeHot100;

/**
 * 11.盛最多水的容器
 */

public class Q7 {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;

        while (start < end) {
            result = Math.max(Math.min(height[start], height[end]) * (end - start), result);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }

}
