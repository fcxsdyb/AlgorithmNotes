package Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ21 调整数组顺序使奇数位于偶数前面(一)
 * 输入一个长度为 n 整数数组，实现一个函数来调整该数组中数字的顺序
 * 使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * 0 <= n <= 5000, 0 <= 数组中每个数的值 <= 10000
 * 空间复杂度O(n), 时间复杂度O(n)
 * 进阶: 空间复杂度O(1), 时间复杂度O(n^2)
 */

public class JZ21 {

    /**
     * Method 1: Insertion Sort.
     */
    public int[] reOrderArray1(int[] array) {
        // 首先是对数值长度进行特判
        if (array == null || array.length == 0) return array;
        //记录已经是奇数的位置
        int j = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            //如果该值为偶数
            if (array[i] % 2 == 0) {
                continue;
            } else {//该值为奇数
                int k = i;
                while (k > j) {
                    //这区间整体向后移动一位
                    array[k] = array[k - 1];
                    k--;
                }
                //移位之后将对应的值赋值
                array[k] = temp;
                j++;
            }
        }
        //返回结果数数组
        return array;
    }

    /**
     * Method 2: Two pointers for odd and even number.
     */
    public int[] reOrderArray2(int[] array) {
        int n = array.length;
        int[] res = new int[n];
        //统计奇数个数
        int odd = 0;
        //遍历统计
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 1)
                odd++;
        }
        //x与y分别表示答案中奇偶数的坐标
        int x = 0, y = odd;
        for (int i = 0; i < n; i++) {
            //奇数在前
            if (array[i] % 2 == 1) {
                res[x] = array[i];
                x++;
                //偶数在后
            } else {
                res[y] = array[i];
                y++;
            }
        }
        return res;
    }

}
