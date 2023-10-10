package LaiOffer.Class1_BasicDataStructure_SortAlgorithm;

/**
 * Merge Sort
 * <p>
 * Time Complexity = O(n log n)
 * Space Complexity = O(n)
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 23, 4, 2, 31, 3};
        mergeSort(array, 0, array.length - 1);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int leftLength = mid - left + 1;
        int rightLength = right - mid;

        int[] L = new int[leftLength];
        int[] R = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            L[i] = array[left + i];
        }
        for (int i = 0; i < rightLength; i++) {
            R[i] = array[mid + 1 + i];
        }

        int l = 0, r = 0;
        int startIndex = left;
        while (l < leftLength && r < rightLength) {
            if (L[l] < R[r]) {
                array[startIndex] = L[l];
                l++;
            } else {
                array[startIndex] = R[r];
                r++;
            }
            startIndex++;
        }

        while (l < leftLength) {
            array[startIndex++] = L[l++];
        }
        while (r < rightLength) {
            array[startIndex++] = R[r++];
        }
    }
}
