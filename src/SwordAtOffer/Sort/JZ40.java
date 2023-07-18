package SwordAtOffer.Sort;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ40 最小的K个数
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)
 * 0 <= k, n <= 10000
 * 0 <= 数组中所有数字的值 <= 1000
 * 空间复杂度O(n)，时间复杂度O(n log k)
 */

public class JZ40 {

    /**
     * Method 1: Quicksort.
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //排除特殊情况
        if (k == 0 || input.length == 0)
            return res;
        //排序
        Arrays.sort(input);
        //因为k<=input.length,取前k小
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    /**
     * Handwritten Quicksort.
     */
    public ArrayList<Integer> GetLeastNumbers_Solution_special(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);
        //根据题意要求，如果K>数组的长度，返回一个空的数组
        if (k > input.length || k == 0)
            return res;
        quickSort(input, res, k, 0, input.length - 1);
        return res;
    }

    private void quickSort(int[] input, ArrayList<Integer> res, int k, int left, int right) {
        //快排的实现方式有多种，我们选择了其中的一种
        int start = left;
        int end = right;
        while (left < right) {
            while (left < right && input[right] >= input[start]) {
                right--;
            }
            while (left < right && input[left] <= input[start]) {
                left++;
            }
            swap(input, left, right);
        }
        swap(input, left, start);
        //注意这里，start是数组中元素的下标。在start之前的元素都是比start指向的元素小，
        //后面的都是比他大。如果k==start，正好start之前的k个元素是我们要找的，也就是
        //数组中最小的k个，如果k>start，说明前k个元素不够，我们还要往后再找找。如果
        //k<start，说明前k个足够了，我们只需要在start之前找k个即可。
        if (left > k) {
            quickSort(input, res, k, start, left - 1);
        } else if (left < k) {
            quickSort(input, res, k, left + 1, end);
        } else {
            //取前面的k个即可
            for (int m = 0; m < k; ++m) {
                res.add(input[m]);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * Method 2: Heapsort. Using PriorityQueue to simply store the smallest elements, it will poll the largest element
     * directly.
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //排除特殊情况
        if (k == 0 || input.length == 0)
            return res;
        //大根堆
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        //构建一个k个大小的堆
        for (int i = 0; i < k; i++)
            q.offer(input[i]);
        for (int i = k; i < input.length; i++) {
            //较小元素入堆
            if (q.peek() > input[i]) {
                q.poll();
                q.offer(input[i]);
            }
        }
        //堆中元素取出入数组
        for (int i = 0; i < k; i++)
            res.add(q.poll());
        return res;
    }

}
