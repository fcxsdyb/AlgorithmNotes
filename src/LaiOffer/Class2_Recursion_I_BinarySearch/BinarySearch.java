package LaiOffer.Class2_Recursion_I_BinarySearch;

/**
 * Binary Search
 * <p>
 * Time Complexity = O(log n)
 * Space Complexity = O(1)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 7, 12, 14, 23, 54};
        System.out.println(binarySearch(array, 6));
        System.out.println(binarySearch(array, 14));
    }

    private static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
