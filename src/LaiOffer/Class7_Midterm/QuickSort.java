package LaiOffer.Class7_Midterm;

public class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
        if (array == null || array.length == 0) {
            return;
        }

        if (low < high) {
            int pivot = partition(array, low, high);

            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivotIndex = getPivot(low, high);
        int pivot = array[pivotIndex];
        int left = low, right = high - 1;
        swap(array, pivotIndex, high);
        while (left <= right) {
            if (array[left] < pivot) {
                left++;
            } else if (array[right] >= pivot) {
                right--;
            } else {
                swap(array, left++, right--);
            }
        }
        swap(array, left, high);
        return left;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int getPivot(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 6, 7, 7, 43, 34, 3, 4};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
