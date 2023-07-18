package SwordAtOffer.Other;

import java.lang.*;

/**
 * 剑指Offer
 * JZ58 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果
 * 对于一个给定的字符序列  S ，请你把其循环左移 K 位后的序列输出
 * 例如，字符序列 S = ”abcXYZdef” , 要求输出循环左移 3 位后的结果，即 “XYZdefabc”
 * 0 <= 字符串长度 <= 100, 0 <= n <= 100
 * 空间复杂度O(n), 时间复杂度O(n)
 */

public class JZ58 {

    /**
     * Method 1: Three times reversal.
     */
    public String LeftRotateString1(String str, int n) {
        //取余，因为每次长度为n的旋转数组相当于没有变化
        if (str.isEmpty() || str.length() == 0)
            return "";
        int m = str.length();
        n = n % m;
        //第一次逆转全部元素
        char[] s = str.toCharArray();
        reverse1(s, 0, m - 1);
        //第二次只逆转开头m个
        reverse1(s, 0, m - n - 1);
        //第三次只逆转结尾m个
        reverse1(s, m - n, m - 1);
        return new String(s);
    }

    //反转函数
    private void reverse1(char[] s, int start, int end) {
        while (start < end) {
            swap1(s, start++, end--);
        }
    }

    //交换函数
    private void swap1(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    /**
     * Method 2: Using StringBuilder to split string into two pieces and add into a entire string.
     */
    public String LeftRotateString2(String str, int n) {
        //取余，因为每次长度为n的旋转数组相当于没有变化
        if (str.isEmpty() || str.length() == 0)
            return "";
        int m = str.length();
        //取余，因为每次长度为m的旋转数组相当于没有变化
        n = n % m;
        StringBuilder res = new StringBuilder();
        //先遍历后面的，放到前面
        for (int i = n; i < m; i++)
            res.append(str.charAt(i));
        //再遍历前面的放到后面
        for (int i = 0; i < n; i++)
            res.append(str.charAt(i));
        return res.toString();
    }

}
