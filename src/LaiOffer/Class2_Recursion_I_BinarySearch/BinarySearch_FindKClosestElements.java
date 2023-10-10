package LaiOffer.Class2_Recursion_I_BinarySearch;

import java.util.Arrays;

/**
 * Apply binary search in finding K elements in the array that is closest to the target number
 * <p>
 * Variant 1.4 application: How to find K elements in the array that is closest to the target number?
 * <p>
 * Time Complexity = O(log n + k)
 * Space Complexity = O(k)
 */
public class BinarySearch_FindKClosestElements {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 8, 9, 10, 24};
        int[] res = kClosestElement(array, 4, 3);
        if (res != null) {
            Arrays.sort(res);
            for (int num : res) {
                System.out.print(num + " ");
            }
        }
    }

    private static int[] kClosestElement(int[] array, int target, int k) {
        if (array == null || array.length < k) {
            return null;
        }

        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                end = mid;
            } else if (array[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (Math.abs(array[start] - target) < Math.abs(array[end] - target)) {
                res[i] = array[start];
                start--;
            } else {
                res[i] = array[end];
                end++;
            }
        }
        return res;
    }
}
