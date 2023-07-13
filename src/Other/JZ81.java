package Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ81 调整数组顺序使奇数位于偶数前面(二)
 * 输入一个长度为 n 整数数组，数组里面可能含有相同的元素，实现一个函数来调整该数组中数字的顺序
 * 使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，对奇数和奇数，偶数和偶数之间的相对位置不做要求
 * 但是时间复杂度和空间复杂度必须如下要求
 * 0 <= n <= 50000， 0 <= 数组中的每个数 <= 10000
 * 空间复杂度O(1), 时间复杂度O(n)
 */

public class JZ81 {

    /**
     * Method: Using two pointers from the head and tail of the array to traverse the array. Compare and swap.
     */
    public int[] reOrderArrayTwo(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            while (low < high && array[low] % 2 == 1) {
                ++low;
            }
            while (low < high && array[high] % 2 == 0) {
                --high;
            }
            if (low < high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
        return array;
    }
}
