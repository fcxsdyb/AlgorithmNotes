package Search;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ11 旋转数组的最小数字
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组
 * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的
 * 给定这样一个旋转数组，求数组中的最小值。
 * 1 <= n <= 10000, 0 <= 数组中每个元素的值 <= 10000
 * 空间复杂度O(1), 时间复杂度O(log n)
 */

public class JZ11 {

    /**
     * Method: Using binary search
     */
    public int minNumberInRotateArray(int[] array) {
        // 特殊情况判断
        if (array.length == 0) {
            return 0;
        }
        // 左右指针i j
        int i = 0, j = array.length - 1;
        // 循环
        while (i < j) {
            // 找到数组的中点 m
            int m = (i + j) / 2;
            // m在左排序数组中，旋转点在 [m+1, j] 中
            if (array[m] > array[j]) i = m + 1;
                // m 在右排序数组中，旋转点在 [i, m]中
            else if (array[m] < array[j]) j = m;
                // 缩小范围继续判断
            else j--;
        }
        // 返回旋转点
        return array[i];
    }

}
