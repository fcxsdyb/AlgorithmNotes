package LaiOffer.Class16_DynamicProgramming_III;

/**
 * DP Question 4:
 * Given an integer array A[n]. There are repeated queries asking for the sum between A[i] and A[j],
 * then what should we do in order to speed up the query. (i <= j)
 */
public class DP_SpeedUpQuery {

    /**
     * Solution 1:
     * Cache every possible start and end
     *
     * Solution 2:
     * Path-Prefix
     * Sum[3][7] = PathPrefixSum[7] - PathPrefixSum[3] + input[3]
     */

}
