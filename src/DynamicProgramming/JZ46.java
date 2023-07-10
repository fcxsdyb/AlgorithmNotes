package DynamicProgramming;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ46 把数字翻译成字符串
 * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'
 * 现在给一串数字，返回有多少种可能的译码结果
 * 0 <= 字符串长度 <= 90
 * 空间复杂度O(n), 时间复杂度O(n)
 */

public class JZ46 {

    /**
     * Method: Dynamic Programming.
     */
    public int solve(String nums) {
        //排除0
        if (nums.equals("0"))
            return 0;
        //排除只有一种可能的10 和 20
        if (nums == "10" || nums == "20")
            return 1;
        //当0的前面不是1或2时，无法译码，0种
        for (int i = 1; i < nums.length(); i++) {
            if (nums.charAt(i) == '0')
                if (nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2')
                    return 0;
        }
        int[] dp = new int[nums.length() + 1];
        //辅助数组初始化为1
        Arrays.fill(dp, 1);
        for (int i = 2; i <= nums.length(); i++) {
            //在11-19，21-26之间的情况
            if ((nums.charAt(i - 2) == '1' && nums.charAt(i - 1) != '0') || (nums.charAt(i - 2) == '2' && nums.charAt(i - 1) > '0' && nums.charAt(i - 1) < '7'))
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }
        return dp[nums.length()];
    }

}
