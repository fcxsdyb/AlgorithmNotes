package Sort;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ3 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次
 * 请找出数组中任意一个重复的数字
 * 0 <= n <= 10000
 * 空间复杂度O(n)，时间复杂度O(n)
 */

public class JZ3 {

    /**
     * Method 1: Hashtable.
     */
    public int duplicate1(int[] numbers) {
        //哈希表记录重复
        HashMap<Integer, Integer> mp = new HashMap<>();
        //遍历数组
        for (int i = 0; i < numbers.length; i++) {
            //如果没有出现过就加入哈希表
            if (!mp.containsKey(numbers[i]))
                mp.put(numbers[i], 1);
                //否则就是重复数字
            else
                return numbers[i];
        }
        //没有重复
        return -1;
    }

    /**
     * Method 2: Since the length of array is n and all the numbers are between 0 to n - 1, let all the number switch to
     * its index array position. If two number has the same index, then return.
     */
    //交换函数
    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    public int duplicate2(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            //该位置本来就是对的
            if (numbers[i] == i)
                continue;
                //位置不对，需要换到自己对应的位置
            else {
                //对应位置相等，重复
                if (numbers[i] == numbers[numbers[i]])
                    return numbers[i];
                    //交换位置
                else {
                    swap(numbers, i, numbers[i]);
                    i--;
                }
            }
        }
        //没有重复
        return -1;
    }

}
