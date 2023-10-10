package LaiOffer.Class5_Heap_GraphSearchAlgorithms_I;

/**
 * Dijkstra Question 1: Given a matrix of size NxN, and for each row the elements are sorted in ascending order.
 * And for each column the elements are also sorted in ascending order.
 * How to find the smallest k element in it?
 * <p>
 * Solution:
 * 1. Initial state (start node): matrix[0][0]
 * 2. Node expansion/Generation rule: Expand[0][0]
 * i. Generate[0][1], add into the queue
 * ii. Generate[1][0], add into the queue
 * 3. Termination Condition: when the k-th element is popped out of the queue
 * 4. De-duplication for duplicated expanded element
 * <p>
 * Time Complexity: O(k log k)
 * Space Complexity = O(n^2) For the matrix for whether this node has been generated or not
 */
public class Dijkstra_FindSmallestKInSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9}
        };
    }

}
