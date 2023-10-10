package LaiOffer.Class8_HashTable_String_I;

/**
 * HashTable Question 2: If there is missing number from 1 to n in an unsorted array.
 * How to find it in O(n) time? Size of the array is n - 1.
 */
public class HashTable_FindMissingNum {

    /**
     * Solution 1: HashSet
     * Step 1: Use a hashset to store all the elements.
     * Step 2: Iterate over all elements from 1 to n to check the missing value.
     *
     * Time Complexity = O(n)
     * Space Complexity = O(n)
     */

    /**
     * Solution 2: XOR (bit operation)
     * Step 1: XOR all the elements in the array.
     * Step 2: Start with result in the step 1 and do the XOR from 1 to n, the final result is the missing number.
     *
     * Time Complexity = O(n)
     * Space Complexity = O(1)
     */

}
