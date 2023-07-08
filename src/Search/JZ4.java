package Search;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ4 二维数组中的查找
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 矩阵的长宽满足 0 <= n, m <= 500, 0 <= 矩阵中每个元素的值 <= 10^9
 * 空间复杂度O(1), 时间复杂度O(n + m)
 */

public class JZ4 {

    /**
     * Method 1: Brute Force.
     */
    public boolean Find1(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method 2: Find target number from the left side of the array.
     */
    public boolean Find2(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        // 左下
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Method 3: Find target number from the right side of the array.
     */
    public boolean Find3(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        // 右上
        int row = 0;   //注意
        int col = cols - 1;    //注意
        while (row < rows && col >= 0) {    //注意
            if (array[row][col] < target) {
                row++;        //注意
            } else if (array[row][col] > target) {
                col--;      //注意
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Method 4: Using binary search.
     */
    public boolean Find4(int target, int[][] array) {
        //优先判断特殊
        if (array.length == 0)
            return false;
        int n = array.length;
        if (array[0].length == 0)
            return false;
        int m = array[0].length;
        //从最左下角的元素开始往左或往上
        for (int i = n - 1, j = 0; i >= 0 && j < m; ) {
            //元素较大，往上走
            if (array[i][j] > target)
                i--;
                //元素较小，往右走
            else if (array[i][j] < target)
                j++;
            else
                return true;
        }
        return false;
    }
}
