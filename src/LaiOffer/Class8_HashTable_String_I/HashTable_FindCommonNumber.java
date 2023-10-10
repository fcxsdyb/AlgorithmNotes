package LaiOffer.Class8_HashTable_String_I;

/**
 * HashTable Question 3: Find the common numbers between two sorted arrays.
 * Assumption array m, n and m's length is larger than n.
 */
public class HashTable_FindCommonNumber {

    /**
     * Solution 1: Binary Search
     * Using binary search to check all the elements in the short array in the long array.
     *
     * Time Complexity = O(n log m)
     * Space Complexity = O(1)
     */

    /**
     * Solution 2: HashTable
     * Store all the elements in the shorter array into hashtable.
     * Check all the elements in longer array against hashtable.
     *
     * Time Complexity = O(m + n)
     * Space Complexity = O(min(m, n))
     */

    /**
     * Solution 3: Direct compare and move
     *
     * Time Complexity = O(m + n)
     * Space Complexity = O(1)
     */

}
