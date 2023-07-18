package SwordAtOffer.Other;

import java.lang.*;

/**
 * 剑指Offer
 * JZ43 整数中1出现的次数（从1到n整数中1出现的次数）
 * 输入一个整数 n ，求 1～n 这 n 个整数的十进制表示中 1 出现的次数
 * 例如， 1~13 中包含 1 的数字有 1、10、11、12、13 因此共出现 6 次
 * 1 <= n <= 30000
 * 空间复杂度O(1), 时间复杂度O(n log n)
 */

public class JZ43 {

    /**
     * Method 1: Using a genius method to check for each bit. Here is the following algorithm:
     * ⌊n / 10^(i+1)⌋ * 10^i + min(max(n%10^(i+1) − 10^i + 1, 0), 10^k)
     */
    public int NumberOf1Between1AndN_Solution1(int n) {
        int res = 0;
        //MulBase = 10^i
        long MulBase = 1;
        //每位数按照公式计算
        for (int i = 0; MulBase <= n; i++) {
            //根据公式添加
            res += (n / (MulBase * 10)) * MulBase + Math.min(Math.max(n % (MulBase * 10) - MulBase + 1, (long) 0), MulBase);
            //扩大一位数
            MulBase *= 10;
        }
        return res;
    }

    /**
     * Method 2: Brute Force. Check for each bit in all the number, if it's 1 then count it.
     */
    public int NumberOf1Between1AndN_Solution2(int n) {
        int res = 0;
        //遍历1-n
        for (int i = 1; i <= n; i++) {
            //遍历每个数的每一位
            for (int j = i; j > 0; j = j / 10) {
                //遇到数字1计数
                if (j % 10 == 1)
                    res++;
            }
        }
        return res;
    }

}
