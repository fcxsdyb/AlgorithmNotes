package LaiOffer.Class18_Probability_Sampling_Randomization;

/**
 * Question 5: Given a certain number (100000) of urls, how to find 95-th percentile of all url's length
 */
public class Sampling_FindCertainLength {

    /**
     * Solution 1:
     * 1. Sort all urls according to their lengths.
     * 2. Return input[100000 * 0.95]
     * Time = O(n log n)
     * Space = O(sum of size of all urls)
     *
     * Solution 2:
     * Assume: the maximum length of the url < 4100 letters
     * Use a bucket[4100]:
     * 1. Iterative over all urls one by one, and for each urls X, bucket[X.length]++      O(n)
     * 2.
     *      for (i = 0; i < 4100; i++) {
     *          counter += bucket[i];
     *          if (counter >= 100000 * 0.95) {
     *              return i;
     *          }
     *      }
     * Time = O(n)
     * Space = O(4100)
     */

}
