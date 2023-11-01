package LaiOffer.Class13_DynamicProgramming_I;

/**
 * DP Question 2: Maximal Product when Cutting Rope
 * Given a rope with integer-length n, how to cut the rope into m integer-length parts with length p[0],
 * p[1], ..., p[m-1], in order to get the maximal product of p[0] * p[1] * ... * p[m-1]?
 * m is determined by you and must be greater than O (at least one cut must be made).
 * <p>
 * Solution:
 * 1. Base case: Smallest rope length = 1m   M[1] = ?? -1 invalid input
 * 2. Induction rule:
 * input = 1m 2m 3m 4m 5m ... 10m
 * M[i]  = represents maximal product of a rope with i-meter long (at least one cut must be made).
 */
public class DP_MaximalProductCuttingRope {

    /**
     * Solution 1: 左大段 + 右大段
     * Solution 2: 左大段 + 右小段
     * Solution 3: Recursion
     */

    public static void main(String[] args) {
        MaxProductRope1(10);
        MaxProductRope2(10);
        System.out.println(MaxProductRope3(10));
    }

    private static void MaxProductRope1(int length) {
        int[] M = new int[length + 1];
        M[0] = 0;
        M[1] = 0;

        for (int i = 1; i <= length; i++) {
            int curMax = 0;
            for (int j = 1; j <= i / 2; j++) {
                curMax = Math.max(curMax, Math.max(j, M[j]) * Math.max(i - j, M[i - j]));
            }
            M[i] = curMax;
        }

        System.out.println(M[length]);
    }


    private static void MaxProductRope2(int length) {
        int[] M = new int[length + 1];
        M[0] = 0;
        M[1] = 0;

        for (int i = 1; i <= length; i++) {
            int curMax = 0;
            for (int j = 1; j <= i; j++) {
                curMax = Math.max(curMax, Math.max(j, M[j]) * (i - j));
            }
            M[i] = curMax;
        }

        System.out.println(M[length]);
    }

    private static int MaxProductRope3(int length) {
        if (length <= 1) {
            return 0;
        }

        int curMax = 0;
        for (int i = 1; i < length; i++) {
            int best = Math.max(length - i, MaxProductRope3(length - i));
            curMax = Math.max(curMax, i * best);
        }

        return curMax;
    }

}
