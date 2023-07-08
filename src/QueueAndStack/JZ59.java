package QueueAndStack;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ59 滑动窗口的最大值
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 * 窗口大于数组长度或窗口长度为0的时候，返回空
 * 1 <= n <= 10000, 0 <= size <= 10000, 数组中每个元素的值的绝对值 <= 10000
 * 空间复杂度O(n), 时间复杂度O(n)
 */

public class JZ59 {

    /**
     * Method 1: Brute Force.
     */
    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //窗口大于数组长度的时候，返回空
        if (size <= num.length && size != 0)
            //数组后面要空出窗口大小，避免越界
            for (int i = 0; i <= num.length - size; i++) {
                //寻找每个窗口最大值
                int max = 0;
                for (int j = i; j < i + size; j++) {
                    if (num[j] > max)
                        max = num[j];
                }
                res.add(max);
            }
        return res;
    }

    /**
     * Method 2: Using ArrayDeque which is a queue can add and delete elements from the head or the tail.
     */
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //窗口大于数组长度的时候，返回空
        if (size <= num.length && size != 0) {
            //双向队列
            ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
            //先遍历一个窗口
            for (int i = 0; i < size; i++) {
                //去掉比自己先进队列的小于自己的值
                while (!dq.isEmpty() && num[dq.peekLast()] < num[i])
                    dq.pollLast();
                dq.add(i);
            }
            //遍历后续数组元素
            for (int i = size; i < num.length; i++) {
                //取窗口内的最大值
                res.add(num[dq.peekFirst()]);
                while (!dq.isEmpty() && dq.peekFirst() < (i - size + 1))
                    //弹出窗口移走后的值
                    dq.pollFirst();
                //加入新的值前，去掉比自己先进队列的小于自己的值
                while (!dq.isEmpty() && num[dq.peekLast()] < num[i])
                    dq.pollLast();
                dq.add(i);
            }
            res.add(num[dq.pollFirst()]);
        }
        return res;
    }

}
