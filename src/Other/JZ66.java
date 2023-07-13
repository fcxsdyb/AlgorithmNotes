package Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ66 构建乘积数组
 * 给定一个数组 A[0,1,...,n-1] ,请构建一个数组 B[0,1,...,n-1]
 * 其中 B 的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]（除 A[i] 以外的全部元素的的乘积）
 * 程序中不能使用除法
 * 注意：规定 B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2]
 * 对于 A 长度为 1 的情况，B 无意义，故而无法构建，用例中不包括这种情况
 * 1 <= n <= 10, 所有元素的绝对值 <= 10
 */

public class JZ66 {

    /**
     * Method 1: From left to right and from right to left, using array to multiple all the previous number before it.
     * After multiply the front part, multiply the back part.
     */
    public int[] multiply1(int[] A) {
        //初始化数组B
        int[] B = new int[A.length];
        B[0] = 1;
        //先乘左边，从左到右
        for (int i = 1; i < A.length; i++)
            //每多一位由数组B左边的元素多乘一个前面A的元素
            B[i] = B[i - 1] * A[i - 1];
        int temp = 1;
        //再乘右边，从右到左
        for (int i = A.length - 1; i >= 0; i--) {
            //temp为右边的累乘
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }

}
