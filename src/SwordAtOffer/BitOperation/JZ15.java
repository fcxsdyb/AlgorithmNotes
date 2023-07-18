package SwordAtOffer.BitOperation;

/**
 * 剑指Offer
 * JZ15 二进制中1的个数
 * 输入一个整数 n ，输出该数32位二进制表示中1的个数
 * 其中负数用补码表示
 * -2^31 <= n <= 2^31 - 1
 * 即 -2147483648 <= n <= 2147483647
 */

public class JZ15 {

    /**
     * Method 1: Bits Operation.
     */
    public int NumberOf1_1(int n) {
        int res = 0;
        //遍历32位
        for (int i = 0; i < 32; i++) {
            //按位比较
            if ((n & (1 << i)) != 0)
                res++;
        }
        return res;
    }

    /**
     * Method 2: Optimal Bits Operation. There is a rule: n & n-1 will let the lowest 1 change to 0. Count the times of
     * it to change to 0. In this way can deduct all the 1 in a number with this operation.
     */
    public int NumberOf1_2(int n) {
        int res = 0;
        //当n为0时停止比较
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }


}
