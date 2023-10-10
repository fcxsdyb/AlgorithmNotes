package LeetCodeHot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 169.多数元素
 */

public class Q57 {

    /**
     * 1.Vote
     */
    public int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

    /**
     * 2.Hashtable
     */

}
