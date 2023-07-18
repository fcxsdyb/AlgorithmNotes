package SwordAtOffer.Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ50 第一个只出现一次的字符
 * 在一个长为 n 字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）（从0开始计数）
 * 0 <= n <= 10000, 且字符串只有字母组成
 * 空间复杂度O(n), 时间复杂度O(n)
 */

public class JZ50 {

    /**
     * Method 1: Hashtable.
     */
    public int FirstNotRepeatingChar1(String str) {
        HashMap<Character, Integer> mp = new HashMap<>();
        //统计每个字符出现的次数
        for (int i = 0; i < str.length(); i++)
            mp.put(str.charAt(i), mp.getOrDefault(str.charAt(i), 0) + 1);
        //找到第一个只出现一次的字母
        for (int i = 0; i < str.length(); i++)
            if (mp.get(str.charAt(i)) == 1)
                return i;
        //没有找到
        return -1;
    }

    /**
     * Method 2: Using queue and hashtable by traverse the array for once to solve the problem. Using hashtable to
     * record each character occur position, if more than 1 time than give -1.
     */
    public int FirstNotRepeatingChar2(String str) {
        //统计字符出现的位置
        HashMap<Character, Integer> mp = new HashMap<>();
        Queue<Character> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            //没有出现过的字符
            if (!mp.containsKey(str.charAt(i))) {
                mp.put(str.charAt(i), i);
                q1.offer(str.charAt(i));
                q2.offer(i);
                //找到重复的字符
            } else {
                //位置置为-1
                mp.put(str.charAt(i), -1);
                //弹出前面所有的重复过的字符
                while (!q1.isEmpty() && mp.get(q1.peek()) == -1) {
                    q1.poll();
                    q2.poll();
                }
            }
        }
        return q2.isEmpty() ? -1 : q2.poll();
    }

}
