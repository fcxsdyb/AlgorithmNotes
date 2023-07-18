package SwordAtOffer.DynamicProgramming;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ48 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * length <= 40000
 */

public class JZ48 {

    /**
     * Method 1: Using hashtable and a moving window with two pointers to check the window's contain elements.
     */
    public int lengthOfLongestSubstring1(String s) {
        //哈希表记录窗口内非重复的字符
        HashMap<Character, Integer> mp = new HashMap<>();
        int res = 0;
        //设置窗口左右边界
        for (int left = 0, right = 0; right < s.length(); right++) {
            //窗口右移进入哈希表统计出现次数
            if (mp.containsKey(s.charAt(right)))
                mp.put(s.charAt(right), mp.get(s.charAt(right)) + 1);
            else
                mp.put(s.charAt(right), 1);
            //出现次数大于1，则窗口内有重复
            while (mp.get(s.charAt(right)) > 1)
                //窗口左移，同时减去该字符的出现次数
                mp.put(s.charAt(left), mp.get(s.charAt(left++)) - 1);
            //维护子串长度最大值
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    /**
     * Method 2: Dynamic Programming with Hashtable.
     */
    public static int lengthOfLongestSubstring2(String s) {
        //哈希表记录窗口内非重复的字符及其下标
        HashMap<Character, Integer> mp = new HashMap<>();
        int res = 0;
        //dp[i]表示以下标i结尾的字符串最长不含重复子串的长度
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = 1;
            //哈希表中没有，说明不重复
            if (!mp.containsKey(s.charAt(i - 1)))
                //前一个加1
                dp[i] = dp[i - 1] + 1;
                //遇到重复字符
            else
                dp[i] = Math.min(dp[i - 1] + 1, i - mp.get(s.charAt(i - 1)));
            //加入哈希表
            mp.put(s.charAt(i - 1), i);
            //维护最大值
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
