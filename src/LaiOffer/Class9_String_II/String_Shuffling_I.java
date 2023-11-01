package LaiOffer.Class9_String_II;

import java.util.Arrays;

/**
 * String Advance 1.1: String Shuffling 1st direction.
 * "A1B2C3D4E5" -> "ABCDE12345"
 */
public class String_Shuffling_I {

    public static void main(String[] args) {
        char[] array = "A1B2C3D4E5".toCharArray();
        shuffling(array);
    }

    private static void shuffling(char[] array) {
        mergeShuffling(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeShuffling(char[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeShuffling(array, low, mid);
            mergeShuffling(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(char[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        char[] L = new char[n1];
        char[] R = new char[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[low + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }

        int l = 0, r = 0;
        int start = low;
        while (l < n1 && r < n2) {
            if (Character.isLetter(L[l]) || (L[l] <= R[r] && !Character.isLetter(R[r]))) {
                array[start++] = L[l++];
            } else {
                array[start++] = R[r++];
            }
        }

        while (l < n1) {
            array[start++] = L[l++];
        }
        while (r < n2) {
            array[start++] = R[r++];
        }

    }

}
