package LaiOffer.Class10_BitOperation;

/**
 * Bit Operation Basic Question 3: Determine whether a number x is a power of 2 (x == 2 ^ n) n > 0
 */
public class BitOperation_CheckPowerOf2 {

    /**
     * Solution 1: Iterative % 2.
     * If the given number has an item equals to 1 except for the first item, we see it is not a power of 2.
     *
     * Solution 2: Magic Thought
     * 100000000
     * 011111111
     * ---------
     * 000000000
     *
     * So check (x & (x - 1) == 0 && x != 0), we can get the final result.
     */

}
