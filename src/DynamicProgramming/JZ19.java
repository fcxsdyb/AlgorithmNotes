package DynamicProgramming;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ19 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 1.模式中的字符'.'表示任意一个字符
 * 2.模式中的字符'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 数据范围:
 * 1.str 只包含从 a-z 的小写字母。
 * 2.pattern 只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * 3.0 <= str.length <= 26
 * 4.0 <= pattern.length <= 26
 */

public class JZ19 {

    /**
     * Method: Dynamic Programming: Divide each problem into several small problem and check all the possibility.
     */
    public boolean match(String str, String pattern) {
        int n1 = str.length();
        int n2 = pattern.length();
        //dp[i][j]表示str前i个字符和pattern前j个字符是否匹配
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        //遍历str每个长度
        for (int i = 0; i <= n1; i++) {
            //遍历pattern每个长度
            for (int j = 0; j <= n2; j++) {
                //空正则的情况
                if (j == 0) {
                    dp[i][j] = (i == 0 ? true : false);
                    //非空的情况下 星号、点号、字符
                } else {
                    if (pattern.charAt(j - 1) != '*') {
                        //当前字符不为*，用.去匹配或者字符直接相同
                        if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        //碰到*
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];
                        }
                        //若是前一位为.或者前一位可以与这个数字匹配
                        if (i >= 1 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[n1][n2];
    }

}
