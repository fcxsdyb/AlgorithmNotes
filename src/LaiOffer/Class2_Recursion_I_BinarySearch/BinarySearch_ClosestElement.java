package LaiOffer.Class2_Recursion_I_BinarySearch;

/**
 * Apply binary search in finding the closest value to the target number
 * <p>
 * Variant 1.1 application: How to find an element in the array that is closest to the target number?
 * <p>
 * Time Complexity = O(log n)
 * Space Complexity = O(1)
 */
public class BinarySearch_ClosestElement {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 8, 10, 24};
        System.out.println(closestElement(array, 6));
    }

    private static int closestElement(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return array[mid];
            } else if (array[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (Math.abs(target - array[start]) <= Math.abs(target - array[end])) {
            return array[start];
        } else {
            return array[end];
        }
    }

}
