package LaiOffer.Class16_DynamicProgramming_III;

/**
 * DP question 1: 一个unsorted一维数组最长连续1的问题
 * A[n] = 01101010101111100000101010101001111111
 */
public class DP_Contiguous1 {

    /**
     * Solution:
     * 1. Base case: M[0] = input[0] only 1 element in the input
     * 2. Induction rule: M[i] represents [from the O-th element to the i-th element] the longest contiguous 1s,
     * (including the i-th element.)
     *
     * M[i] = 1 + M[i - 1]    if input[i] == 1
     *          0               otherwise
     */

}
