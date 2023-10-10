package LaiOffer.Class3_Queue_Stack_LinkedList;

/**
 * LinkedList Question 6:
 * Given a linked list and a target value x, partition it such that all nodes less than x are listed
 * before the nodes larger than or equal to target value x.
 * (keep the original relative order of the nodes in each of the two partitions)
 * <p>
 * For example,
 * Input: 1 -> 6 -> 3 -> 2a -> 5 -> 2b and target x = 4
 * Result: 1 -> 3 -> 2a -> 2b -> 6 -> 5.
 */
public class LinkedList_PartitionList {

    /**
     * Solution:
     * Step 1: Initialize two dummy nodes, one for the element smaller than target number, another one for the larger
     * Step 2: Follow the order, go through all the nodes in the given linked list, put the nodes into relative list
     * Step 3: Link the larger list after the small element list
     * Step 4: Ensure all the nodes have correct next value and last element for the large list should point to null
     */

}
