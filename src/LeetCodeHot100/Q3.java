package LeetCodeHot100;

/**
 * 3.无重复字符的最长子串
 */

import java.util.HashMap;
import java.util.Map;

public class Q3 {

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        while (end < s.length() && start < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }

            result = Math.max((end - start + 1), result);
            map.put(s.charAt(end), end);
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "abba";
        System.out.println(lengthOfLongestSubstring(a));
    }

}
