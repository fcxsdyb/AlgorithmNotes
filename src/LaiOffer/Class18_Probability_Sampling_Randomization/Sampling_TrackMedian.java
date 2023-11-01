package LaiOffer.Class18_Probability_Sampling_Randomization;

/**
 * Question 4: Given an unlimited data flow, how to keep track of the median of the numbers read so far? O(n) space
 */
public class Sampling_TrackMedian {

    /**
     * Solution 1: sort  O(n log n)
     *
     * Solution 2: Insertion sort O(n) for each element comes in
     *
     * Solution 3:
     * Case 1: if Max-heap.size() > Min-heap.size().
     *      Case1.1 X < Max_heap.top(). We call Max-heap.insert(X) and then Min-heap.insert(Max-heap.pop())
     *      Case1.2 else: Min-heap.insert(X)
     * Case 2: if Max-heap.size() == Min-heap.size().
     *      Case2.1 X < Max_heap.top(). We call Max-heap.insert(X).
     *      Case2.2 else: Min-heap.insert(X), call Max-heap.insert(Min-heap.pop())
     * Be careful, we are keep the Max-heap.size() >= Min-heap.size()
     *
     * Follow up: Delong (What if the number of element is toooo large to be stored into the memory)
     *      SMALL                   LARGE
     *      50%                     50%
     *      Max-heap                Min-heap
     * xxxxxxX XXXXX                YYYYY Yyyyyyyyy
     *      60     99              101   180
     *      Largest in small    Smallest in large
     * Assume that we only have 1G memory, when we found out that Map-heap.top() < 60, then we know we must
     * re-sort all data on the left hand side.
     *
     * System Design Class will cover external sort
     */

}
