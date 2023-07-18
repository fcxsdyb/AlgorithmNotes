package SwordAtOffer.BitOperation;

import java.lang.*;

/**
 * 剑指Offer
 * JZ16 数值的整数次方
 * 实现函数 double Power(double base, int exponent)，求base的exponent次方。
 * 注意：
 * 1.保证base和exponent不同时为0
 * 2.不得使用库函数，同时不需要考虑大数问题
 * 3.有特殊判题，不用考虑小数点后面0的位数
 * base的绝对值 <= 100, exponent的绝对值 <= 100, 最终结果的绝对值 <= 10^4
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ16 {

    /**
     * Method 1: Using basic logic.
     */
    public double Power1(double base, int exponent) {
        //处理负数次方
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double res = 1.0;
        //累乘
        for (int i = 0; i < exponent; i++)
            res *= base;
        return res;
    }

    /**
     * Method 2: Dividing the problem into several small problems.
     */
    //快速幂
    private static double Pow(double x, int y) {
        double res = 1;
        while (y != 0) {
            //可以再往上乘一个
            if ((y & 1) != 0)
                res *= x;
            //叠加
            x *= x;
            //减少乘次数
            y = y >> 1;
        }
        return res;
    }

    public static double Power2(double base, int exponent) {
        //处理负数次方
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        return Pow(base, exponent);
    }

    public static void main(String[] args) {
        System.out.println(Power2(2, 10));
    }

}
