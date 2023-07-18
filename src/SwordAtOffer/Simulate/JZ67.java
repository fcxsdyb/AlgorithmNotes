package SwordAtOffer.Simulate;

import java.lang.*;

/**
 * 剑指Offer
 * JZ67 把字符串转换成整数(atoi)
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。传入的字符串可能有以下部分组成:
 * 1. 若干空格
 * 2.（可选）一个符号字符（'+' 或 '-'）
 * 3. 数字，字母，符号，空格组成的字符串表达式
 * 4. 若干空格
 * 转换算法如下:
 * 1. 去掉无用的前导空格
 * 2. 第一个非空字符为+或者-号时，作为该整数的正负号，如果没有符号，默认为正数
 * 3. 判断整数的有效部分：
 * 3.1 确定符号位之后，与之后面尽可能多的连续数字组合起来成为有效整数数字，如果没有有效的整数部分，那么直接返回0
 * 3.2 将字符串前面的整数部分取出，后面可能会存在存在多余的字符(字母，符号，空格等)，这些字符可以被忽略，它们对于函数不应该造成影响
 * 3.3 整数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内
 * 具体来说，小于 −2^31的整数应该被调整为 −2^31 ，大于 2^31 − 1 的整数应该被调整为 2^31 − 1
 * 4. 去掉无用的后导空格
 * 0 <= 字符串长度 <= 100
 * 字符串由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 */

public class JZ67 {

    /**
     * Method 1: Check one by one. And need to check about the Integer maximum value and minimum value.
     */
    public int StrToInt1(String s) {
        //空串
        if (s.isEmpty())
            return 0;
        int res = 0;
        int index = 0;
        int n = s.length();
        //去掉前导空格，如果有
        while (index < n) {
            if (s.charAt(index) == ' ')
                index++;
            else
                break;
        }
        //去掉空格就什么都没有了
        if (index == n)
            return 0;
        int sign = 1;
        //处理第一个符号是正负号的情况
        if (s.charAt(index) == '+')
            index++;
        else if (s.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        //去掉符号就什么都没有了
        if (index == n)
            return 0;
        while (index < n) {
            char c = s.charAt(index);
            //后续非法字符，截断
            if (c < '0' || c > '9')
                break;
            //处理越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10))
                return Integer.MAX_VALUE;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10)))
                return Integer.MIN_VALUE;
            res = res * 10 + sign * (c - '0');
            index++;
        }
        return res;
    }

    /**
     * Method 2: Assume all the possible string as different type of input. Then make the right type of the input.
     */
    public int StrToInt2(String s) {
        //状态转移矩阵
        int[][] states = {
                {0, 1, 2, 3, 1},
                {3, 1, 2, 3, 3},
                {3, 2, 2, 3, 3},
        };
        long res = 0;
        //与int边界比较
        long top = Integer.MAX_VALUE;
        long bottom = Integer.MIN_VALUE;
        int n = s.length();
        int sign = 1;
        //状态从“ ”开始
        int state = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ')
                //空格
                state = states[state][0];
            else if (c == '0')
                //前导0或者中间的0
                state = states[state][1];
            else if (c >= '1' && c <= '9')
                //数字
                state = states[state][2];
            else if (c == '-' || c == '+') {
                //正负号
                state = states[state][4];
                if (state == 1)
                    sign = (c == '-') ? -1 : 1;
                else
                    break;
            } else
                //非法字符
                state = states[state][3];
            if (state == 2) {
                //数字相加
                res = res * 10 + (c - '0');
                //越界处理
                res = (sign == 1) ? Math.min(res, top) : Math.min(res, -bottom);
            }
            if (state == 3)
                break;
        }
        return (int) (sign * res);
    }

}
