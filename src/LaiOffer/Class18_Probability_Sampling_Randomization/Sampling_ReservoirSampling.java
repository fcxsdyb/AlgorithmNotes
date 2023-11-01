package LaiOffer.Class18_Probability_Sampling_Randomization;

import java.util.Arrays;
import java.util.Random;

/**
 * Reservoir sampling is a family of randomized algorithms for randomly choosing a sample of k items from a list S
 * containing n items, where n is either a very large or unknown number. Typically, n is large enough that the list
 * doesn't fit into main memory.
 * <p>
 * Assuming the number of items to select, k, is smaller than the size of the source array, S
 * <p>
 * k element out of n (k << n) - P(1/n)
 */
public class Sampling_ReservoirSampling {

    /**
     * Follow Up:
     * 1. What if we are asked to return k out of n logs
     * <p>
     * 2. What if we ask you to return a random largest number's index
     */

    static void selectKItems(int[] stream, int n, int k) {
        int i; // index for elements in stream[]

        // reservoir[] is the output array. Initialize it
        // with first k elements from stream[]
        int[] reservoir = new int[k];
        for (i = 0; i < k; i++)
            reservoir[i] = stream[i];

        Random r = new Random();

        // Iterate from the (k+1)th element to nth element
        for (; i < n; i++) {
            // Pick a random index from 0 to i.
            int j = r.nextInt(i + 1);

            // If the randomly picked index is smaller than k, then replace the element present at the index
            // with new element from stream
            if (j < k)
                reservoir[j] = stream[i];
        }

        System.out.println(
                "Following are k randomly selected items");
        System.out.println(Arrays.toString(reservoir));
    }

    // Driver Program to test above method
    public static void main(String[] args) {
        int stream[]
                = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = stream.length;
        int k = 5;
        selectKItems(stream, n, k);
    }
    
}
