package SwordAtOffer.Search;

/**
 * 剑指Offer
 * JZ53 数字在升序数组中出现的次数
 * 给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数
 * 1 <= n <= 1000, 0 <= k <= 100, 0 <= 数组中每个元素的值 <= 100
 * 空间复杂度O(1), 时间复杂度O(log n)
 */

public class JZ53 {

    /**
     * Method 1: Binary SwordAtOffer.Search
     */
    //二分查找
    private int bisearch(int[] data, double k) {
        int left = 0;
        int right = data.length - 1;
        //二分左右界
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] < k)
                left = mid + 1;
            else if (data[mid] > k)
                right = mid - 1;
        }
        return left;
    }

    public int GetNumberOfK1(int[] array, int k) {
        //分别查找k+0.5和k-0.5应该出现的位置，中间的部分就全是k
        return bisearch(array, k + 0.5) - bisearch(array, k - 0.5);
    }

}
