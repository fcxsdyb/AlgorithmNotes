package SwordAtOffer.Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ75 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"
 * 当从该字符流中读出前六个字符 “google" 时，第一个只出现一次的字符是 "l"
 * 1 <= n <= 1000, 字符串中的出现的字符一定在ASCII码内
 * 空间复杂度O(n), 时间复杂度O(n)
 */

public class JZ75 {

    /**
     * Method 1: Hashtable.
     */
    private StringBuilder s = new StringBuilder();
    private HashMap<Character, Integer> mp = new HashMap<>();

    //Insert one char from string stream
    public void Insert1(char ch) {
        //插入字符
        s.append(ch);
        //哈希表记录字符出现次数
        mp.put(ch, mp.getOrDefault(ch, 0) + 1);
    }

    //return the first appearance once char in current string stream
    public char FirstAppearingOnce1() {
        //遍历字符串
        for (int i = 0; i < s.length(); i++)
            //找到第一个出现次数为1的
            if (mp.get(s.charAt(i)) == 1)
                return s.charAt(i);
        //没有找到
        return '#';
    }

    /**
     * Method 2: Using hashtable and queue.
     */
    private Queue<Character> q = new LinkedList<>();

    //Insert one char from string stream
    public void Insert2(char ch) {
        //插入字符
        if (!mp.containsKey(ch))
            q.offer(ch);
        //哈希表记录字符出现次数
        mp.put(ch, mp.getOrDefault(ch, 0) + 1);
    }

    //return the first appearance once char in current string stream
    public char FirstAppearingOnce2() {
        while (!q.isEmpty()) {
            //第一个不重复的字符
            if (mp.get(q.peek()) == 1)
                return q.peek();
                //弹出前面的已经重复的字符
            else
                q.poll();
        }
        //都重复了
        return '#';
    }

}
