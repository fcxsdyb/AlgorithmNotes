package LaiOffer.Class12_Recursion_II;

/**
 * Recursion Question 2
 */
public class Recursion_1D2DArray {

    /**
     * 1. 1D array
     *      1.1 MergeSort
     *      1.2 QuickSort
     *
     * 2. 2D array
     *      2.1 8 queen -> n queen
     *      For the ith queen on the ith row, we must make sure the Queen i does not conflict with all previous queens
     *      that have been placed on the board.
     *
     *      int position[n] = {1, 3, 2, 5 ...}
     *                        Q0 Q1 Q2 Q3 .. Q7
     *
     *                                                 root
     *                                  /       |   |   |  |   |   |           \
     *      level0     Q0 is put on 0th col     Q0 is put on 1st col ...   Q0 is put on 7th col
     *               /     ||||||  \
     *      level1  Q1 is put on the 0th col  ....
     *
     *      level2
     *
     *        ...
     *
     *      level7
     *
     *      Each branch check whether they have the same column, row, or slope (with 0, 0) equals to other branch
     *      Time Complexity = O(8^8) -> O(8!)
     *
     *      2.2 How to print 2D array in spiral order (N x N)
     *      1  2  3  4  5
     *     16 17 18 19  6
     *     15 24 25 20  7
     *     15 23 22 21  8
     *     13 12 11 10  9
     *     void printSpiral(int[] a, int offset, int size, int counter) {
     *         if (size <= 1) {
     *             print matrix // base case
     *         }
     *
     *         // top row
     *         for (i = 0; i < size - 1; i++) {
     *             a[0 + offset][i + offset] = counter++ // offset is coordinates of the upper-left corner of the box
     *         }
     *
     *         for (i = 0; i < size - 1; i++) // right column
     *         for (i = 0; i < size - 1; i++) // bottom row
     *         for (i = 0; i < size - 1; i++) // left column
     *
     *         printSpiral(a, offset + 1, size - 2, counter);
     *     }
     *
     */

}
