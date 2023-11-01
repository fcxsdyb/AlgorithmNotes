package LaiOffer.Class9_String_II;

/**
 * String Advance 4.3: Given a 0-1 array, you can flip at most k '0's to '1's.
 * Please find the longest subarray that consists of all '1's.
 * Example:
 * Change k = 4 zero to one, such that the contiguous 1s are longest.
 * 01111101111011110111110
 */
public class String_FlipFindLongest {

    /**
     * Solution: Using sliding window
     * Try to find the sliding window that contains at most k 0s.
     * When to move the right border: when the counter of 0 <= k
     * When to move the left border: when the counter of 0 > k
     */

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0};
        int k = 4;
        int maxLength = longestOnes(arr, k);
        System.out.println(maxLength);
    }

    public static int longestOnes(int[] A, int K) {
        int left = 0, right;
        // Use this to count the zeros in the current window
        int zerosCount = 0;

        int maxLength = 0;

        for (right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                zerosCount++;
            }

            // If zerosCount becomes more than K, move the left pointer of the window to the right
            while (zerosCount > K) {
                if (A[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            // The current window size is (right - left + 1), update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}
