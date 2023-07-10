package Sort;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ51 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
 * 输入一个数组,求出这个数组中的逆序对的总数P，并将P对1000000007取模的结果输出
 * 即输出 P mod 1000000007
 * 50%的数据, size <= 10^4
 * 100%的数据, size <= 10^5
 * 0 <= 数组中所有数字的值 <= 10^9
 * 空间复杂度O(n)，时间复杂度O(n log n)
 */

public class JZ51 {

    /**
     * Method 1: Using mergesort to solve the problem. Check the change times.
     */
    public static int mod = 1000000007;

    public static int mergeSort1(int left, int right, int[] data, int[] temp) {
        //停止划分
        if (left >= right)
            return 0;
        //取中间
        int mid = (left + right) / 2;
        //左右划分合并
        int res = mergeSort1(left, mid, data, temp) + mergeSort1(mid + 1, right, data, temp);
        //防止溢出
        res %= mod;
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++)
            temp[k] = data[k];
        for (int k = left; k <= right; k++) {
            if (i == mid + 1)
                data[k] = temp[j++];
            else if (j == right + 1 || temp[i] <= temp[j])
                data[k] = temp[i++];
                //左边比右边大，答案增加
            else {
                data[k] = temp[j++];
                // 统计逆序对
                res += mid - i + 1;
            }
        }
        return res % mod;
    }

    public static int InversePairs1(int[] array) {
        int n = array.length;
        int[] res = new int[n];
        return mergeSort1(0, n - 1, array, res);
    }

    /**
     * Method 2: Using tree.
     */
    class BIT {
        private int[] tree;
        private int n;

        //初始化树状数组的大小
        public BIT(int m) {
            this.n = m;
            this.tree = new int[m + 1];
        }

        //使数组呈现2、4、8、16这种树状
        public int lowbit(int x) {
            return x & (-x);
        }

        //查询序列1到x的前缀和
        public int query(int x) {
            int res = 0;
            while (x != 0) {
                res += tree[x];
                x -= lowbit(x);
            }
            return res;
        }

        //序列x位置的数加1
        public void update(int x) {
            while (x <= n) {
                tree[x]++;
                x += lowbit(x);
            }
        }
    }

    public int InversePairs2(int[] array) {
        int n = array.length;
        int[] temp = new int[n];
        System.arraycopy(array, 0, temp, 0, n);
        //排序得到一份有序的数组
        Arrays.sort(temp);
        //二分法重新映射，将数字变成其在有序数组中的位置
        for (int i = 0; i < n; ++i)
            //二分法查找在其在有序数组中的位置
            array[i] = Arrays.binarySearch(temp, array[i]) + 1;
        //建立大小为n的树状数组
        BIT bit = new BIT(n);
        int res = 0;
        //统计逆序对
        for (int i = 0; i < n; i++) {
            //前缀和做差
            res = (res + bit.query(n) - bit.query(array[i])) % mod;
            bit.update(array[i]);
        }
        return res;
    }


}
