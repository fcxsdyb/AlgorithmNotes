package LaiOffer.Class14_DynamicProgramming_II;

/**
 * DP question 0: Minimum Number of Jumps
 * Given the same setup as the Jump problem, can you return the minimum number of jumps needed
 * to reach the end instead of just whether it is possible to reach the end?
 */
public class DP_MinimumJump {

    /**
     * Solution:
     * 1. Base case: M[n-1] = 0
     * 2. Induction rule
     *      2.1. M[i] represents the minimum number of jumps needed to jump from the i-th index
     *          to the target (n-1)th index
     *      2.2. M[i] = 1 + min(M[i + j]) where j <= input[i], && i + j < n
     *
     * Time = O(n ^ 2) or O(n * k) where k is the largest number of jumps one can make
     */

}
