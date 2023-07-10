package BitOperation;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ56 数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次
 * 请写程序找出这两个只出现一次的数字
 * 2 <= 数组长度 <= 1000, 0 < 每个数的大小 <= 1000000
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ56 {

    /**
     * Method 1: Hashtable.
     */
    public int[] FindNumsAppearOnce1(int[] array) {
        // write code here
        // 用于返回结果
        int[] res = new int[2];
        // 创建一个哈希表
        HashMap<Integer, Object> set = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            // 如果已经被当作key了，那就直接remove掉
            if (set.containsKey(array[i])) {
                set.remove(array[i], null);
            } else {
                // 否则就添加进去
                set.put(array[i], null);
            }
        }
        int i = 0;
        // 最后拿出来放进返回结果的数组中进行返回
        for (Integer num : set.keySet()) {
            res[i++] = num;
        }
        return res;
    }

    /**
     * Method 2: Bits Operation. Genius Solution.
     */
    public int[] FindNumsAppearOnce2(int[] array) {

        // 先将全部数进行异或运算，得出最终结果
        int tmp = 0;
        for (int num : array) {
            tmp ^= num;
        }

        // 找到那个可以充当分组去进行与运算的数
        // 从最低位开始找起
        int mask = 1;
        while ((tmp & mask) == 0) {
            mask <<= 1;
        }

        // 进行分组，分成两组，转换为两组 求出现一次的数字 去求
        int a = 0;
        int b = 0;
        for (int num : array) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        // 因为题目要求小的数放前面，所以这一做个判断
        if (a > b) {
            int c = a;
            a = b;
            b = c;
        }
        return new int[]{a, b};
    }

}
