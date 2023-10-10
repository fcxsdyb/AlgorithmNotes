package LeetCodeHot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32.最长有效括号
 * 动态规划
 * 状态转移方程
 */

public class Q16 {

    /**
     * 1.Stack
     */
    public int longestValidParentheses1(String s) {
        // 用栈解决括号的合法性问题，向栈中存入下标
        Deque<Integer> stack = new LinkedList<Integer>();
        // 向栈中预置一个-1，将计算长度的方式转化成“）”的下标减去出栈后栈顶元素的下标
        stack.push(-1);
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(i);
            }
            if (')' == s.charAt(i)) {
                stack.pop();
                // 如栈空，则注入新的i作为预置下标
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                len = Math.max(len, i - stack.peek());

            }
        }
        return len;
    }

    /**
     * 2.DP
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

}
