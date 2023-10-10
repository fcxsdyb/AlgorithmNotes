package LaiOffer.Class1_BasicDataStructure_SortAlgorithm;

/**
 * Selection Sort
 * <p>
 * Time Complexity = O(n^2)
 * Space Complexity = O(1)
 */
public class SelectionSort {

    // Selection Sort array[] with size n in ascending order.
    public static void selectionSort(int[] array, int n) {
        int global, temp;
        for (int i = 0; i < n - 1; i++) { //outer loop: how many iterations
            global = i;
            for (int j = i + 1; j < n; j++) { //inner loop: find the global min from the rest elements
                if (array[j] < array[global]) {
                    // record the index of the smallest element
                    global = j;
                }
            }

            //swap the global min with array[i]
            temp = array[i];
            array[i] = array[global];
            array[global] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 23, 5, 16, 7, 7, 43, 34, 3, 5};
        selectionSort(array, array.length);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

}
