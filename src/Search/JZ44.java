package Search;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ44 数字序列中某一位的数字
 * 数字以 0123456789101112131415... 的格式作为一个字符序列
 * 在这个序列中第 2 位（从下标 0 开始计算）是 2 ，第 10 位是 1 ，第 13 位是 1 ，以此类题，请你输出第 n 位对应的数字
 * 0 <= n <= 10^9
 */

public class JZ44 {

    /**
     * Method: Finding the regular pattern of this problem.
     */
    public int findNthDigit(int n) {
        //记录n是几位数
        int digit = 1;
        //记录当前位数区间的起始数字：1,10,100...
        long start = 1;
        //记录当前区间之前总共有多少位数字
        long sum = 9;
        //将n定位在某个位数的区间中
        while (n > sum) {
            n -= sum;
            start *= 10;
            digit++;
            //该区间的总共位数
            sum = 9 * start * digit;
        }
        //定位n在哪个数字上
        String num = "" + (start + (n - 1) / digit);
        //定位n在数字的哪一位上
        int index = (n - 1) % digit;
        return (int) (num.charAt(index)) - (int) ('0');
    }

}
