package Other;

import java.util.*;
import java.lang.*;
import java.math.*;

/**
 * 剑指Offer
 * JZ17 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999
 * 1. 用返回一个整数列表来代替打印
 * 2. n 为正整数，0 < n <= 5
 */

public class JZ17 {

    /**
     * Method: Array.
     */
    public int[] printNumbers(int n) {
        //找到该n+1位数的最小数字
        int end = 1;
        for (int i = 1; i <= n; i++)
            end *= 10;
        //从1遍历到n+1位数的最小数字输出
        int[] res = new int[end - 1];
        for (int i = 1; i < end; i++)
            res[i - 1] = i;
        return res;
    }

}
