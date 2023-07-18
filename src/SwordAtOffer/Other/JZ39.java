package SwordAtOffer.Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ39 数组中出现次数超过一半的数字
 * 给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2
 * n <= 50000, 0 <= 数组中每个数的值 <= 10000
 * 空间复杂度O(1), 时间复杂度O(n)
 */

public class JZ39 {

    /**
     * Method: Hashtable.
     */
    public int MoreThanHalfNum_Solution1(int[] array) {
        //哈希表统计每个数字出现的次数
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        //遍历数组
        for (int i = 0; i < array.length; i++) {
            //统计频率
            if (!mp.containsKey(array[i]))
                mp.put(array[i], 1);
            else
                mp.put(array[i], mp.get(array[i]) + 1);
            //一旦有个数大于长度一半的情况即可返回
            if (mp.get(array[i]) > array.length / 2)
                return array[i];
        }
        return 0;
    }

}
