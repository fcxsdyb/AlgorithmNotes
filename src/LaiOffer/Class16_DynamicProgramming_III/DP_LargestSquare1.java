package LaiOffer.Class16_DynamicProgramming_III;

/**
 * DP question 3a:
 * Given a matrix where every element is either '0' or '1', find the largest sub-square surrounded by '1'.
 * <p>
 * Examples:
 * 1  0  1  1  1
 * 1  1  1  1  1
 * 1  1  0  1  0
 * 1  1  1  1  1
 * 1  1  1  0  0
 */
public class DP_LargestSquare1 {

    /**
     * Solution 1: (non-DP)
     * For
     * For each [x][y] as the top left corner of a square {
     * For all possible edge length {
     * we check all edges
     * }
     * }
     * }
     * Time = O(n ^ 4)
     * <p>
     * Solution 2: DP
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0}
        };

        System.out.println(largestSubSquare(matrix));
    }

    private static int largestSubSquare(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        int[][] vert = new int[m][n];
        int[][] hori = new int[m][n];

        // Populate vert and hori matrices
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    hori[i][j] = (j == 0) ? 1 : hori[i][j - 1] + 1;
                    vert[i][j] = (i == 0) ? 1 : vert[i - 1][j] + 1;
                }
            }
        }

        int maxSize = 0; // To store the size of the largest sub-square

        // Start from the bottom-rightmost corner and move left and up
        for (int i = m - 1; i >= 1; i--) { // We start from 1 because single cell cannot form a square
            for (int j = n - 1; j >= 1; j--) {
                // Find smaller of values at hori[i][j] and vert[i][j]
                int small = Math.min(hori[i][j], vert[i][j]);
                // At this point, we are sure that there is a right vertical line and bottom horizontal line of length at least 'small'

                while (small > maxSize) {
                    // Check if the top vertical line and left horizontal line also have length >= 'small'
                    if (vert[i][j - small + 1] >= small && hori[i - small + 1][j] >= small) {
                        maxSize = small;
                    }
                    small--;
                }
            }
        }

        return maxSize;  // Return size of largest sub-square matrix
    }

}
