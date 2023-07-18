package SwordAtOffer.DynamicProgramming;

/**
 * 剑指Offer
 * JZ10 斐波那契数列
 * 1 <= n <= 40
 * 空间复杂度O(1), 时间复杂度O(n)
 */

public class JZ10 {

    /**
     * Method 1: Recursion.
     */
    public int Fibonacci1(int n) {
        //从0开始，第0项是0，第一项是1
        if (n <= 1)
            return n;
        else {
            //根据公式递归调用函数
            return Fibonacci1(n - 1) + Fibonacci1(n - 2);
        }
    }

    /**
     * Method 2: Dynamic Programming.
     */
    public int Fibonacci2(int n) {
        //从0开始，第0项是0，第一项是1
        if (n <= 1)
            return n;
        int res = 0;
        int a = 0;
        int b = 1;
        //因n=2时也为1，初始化的时候把a=0，b=1
        for (int i = 2; i <= n; i++) {
            //第三项开始是前两项的和,然后保留最新的两项，更新数据相加
            res = (a + b);
            a = b;
            b = res;
        }
        return res;
    }

}
