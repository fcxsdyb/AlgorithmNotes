package LaiOffer.Class5_Heap_GraphSearchAlgorithms_I;

/**
 * Heap Question 1: Find smallest k elements from an unsorted array of size n.
 * We need to discuss the relationship between k and n.
 */
public class Heap_FindSmallestKInUnsortedArray {

    /**
     * Solution 1: Sort it and return first k elements.
     * Using quicksort or mergesort.
     * Time Complexity is O(n log n)
     */

    /**
     * Solution 2: Use min heap.
     * Step 1: Build up a min heap. Cost O(n).
     * Step 2: Keep popping out k elements. Cost(k log n).
     * Time Complexity is O(n + k log n)
     */

    /**
     * Solution 3: Use max heap.
     * Step 1: Put first k elements into a max heap. Cost O(k).
     * Step 2: Iterate from the (k+1)th element to the (n)th element.
     * If element smaller than the max heap root, pop out the max value, and insert this element.
     * Time Complexity is O(k + (n - k) log k)
     */

    /**
     * Solution 4: Quick Partition.
     * Step 1: Random select pivot, check the partition smaller than pivot and larger than the pivot.
     * Step 2:
     * If length of partition smaller than pivot is larger than k, continue doing the same operation.
     * If length of partition smaller than pivot is smaller than k, pop out all n elements in this partition
     * and try to find k - n element in the other side of partition.
     * Time Complexity is O(n^2) worst case; O(n) average case
     */

}
