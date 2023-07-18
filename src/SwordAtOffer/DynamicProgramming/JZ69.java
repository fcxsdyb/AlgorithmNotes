package SwordAtOffer.DynamicProgramming;

/**
 * 剑指Offer
 * JZ69 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * 1 <= n <= 40
 * 空间复杂度O(1), 时间复杂度O(n)
 */

public class JZ69 {

    /**
     * Method 1: Recursion. To see this question as Fibonacci problem.
     */
    public int jumpFloor1(int number) {
        // write code here
        if (number <= 1)
            return 1;
        return jumpFloor1(number - 1) + jumpFloor1(number - 2);
    }

    /**
     * Method 2: Dynamic Programming. Saving space.
     */
    public int jumpFloor2(int number) {
        // write code here
        if (number <= 1)
            return 1;
        int a = 1, b = 1, result = a + b;
        for (int i = 2; i <= number; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

}
