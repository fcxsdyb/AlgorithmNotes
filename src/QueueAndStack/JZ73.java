package QueueAndStack;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ73 翻转单词序列
 * 将一句英文每个单词的顺序进行倒序
 * 1 <= n <= 100
 * 空间复杂度O(n), 时间复杂度O(n), 保证没有只包含空格的字符串
 */

public class JZ73 {

    /**
     * Method 1: Using stack reading all the words spilt by the space then output them one by one.
     */
    public static String ReverseSentence1(String str) {
        Stack<String> stack = new Stack<>();
        String[] split = str.split(" ");

        for (String s : split) {
            stack.push(s);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop() + " ");
        }
        return result.toString();
    }

    /**
     * Method 2: Swap twice. First swap all the words in the string. Then based on the word, swap each by itself to
     * become the correct one.
     */
    //字符串反转函数
    private void reverse(char[] c, int l, int h) {
        //双指针反转
        while (l < h)
            swap(c, l++, h--);
    }

    //字符交换函数
    private void swap(char[] c, int l, int h) {
        char temp = c[l];
        c[l] = c[h];
        c[h] = temp;
    }

    public String ReverseSentence2(String str) {
        int n = str.length();
        char[] c = str.toCharArray();
        //第一次整体反转
        reverse(c, 0, n - 1);
        for (int i = 0; i < n; i++) {
            int j = i;
            //以空格为界找到一个单词
            while (j < n && c[j] != ' ')
                j++;
            //将这个单词反转
            reverse(c, i, j - 1);
            i = j;
        }
        return new String(c);
    }

}
