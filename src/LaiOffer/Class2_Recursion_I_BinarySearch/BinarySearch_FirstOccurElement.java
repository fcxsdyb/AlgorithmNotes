package LaiOffer.Class2_Recursion_I_BinarySearch;

/**
 * Apply binary search in finding the first occurrence of an element
 * <p>
 * Variant 1.2 application: Return the index of the first occurrence of an element
 * <p>
 * Time Complexity = O(log n)
 * Space Complexity = O(1)
 */
public class BinarySearch_FirstOccurElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3, 4, 4, 5, 6};
        System.out.println(firstOccurElement(array, 3));
        System.out.println(firstOccurElement(array, 2));
        System.out.println(firstOccurElement(array, 7));
    }

    private static int firstOccurElement(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                end = mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (array[start] == target) {
            return start;
        }
        if (array[end] == target) {
            return end;
        }
        return -1;
    }

}
