package LaiOffer.Class16_DynamicProgramming_III;

/**
 * DP question 2a: Given a Matrix that contains only 1s and Os, how to find the largest cross
 * with the same arm lengths and the two arms join at the central point of each other.
 * <p>
 * Example:
 * 0 1 0 0
 * 1 1 1 1
 * 0 1 0 0
 * 0 1 0 0
 * return arm_length = 2
 * <p>
 * Time = O(n ^ 2 * n) = O(n ^ 3)
 */
public class DP_Cross1 {

    public static int largestCross(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] top = new int[m][n];
        int[][] bottom = new int[m][n];

        // Initialize for the first row and column
        for (int i = 0; i < m; i++) {
            left[i][0] = matrix[i][0];
            right[i][m - 1] = matrix[i][m - 1];
        }

        for (int j = 0; j < n; j++) {
            top[0][j] = matrix[0][j];
            bottom[n - 1][j] = matrix[n - 1][j];
        }

        // Fill up the top matrix
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    top[i][j] = top[i - 1][j] + 1;
                }
            }
        }

        // Fill up the left matrix
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
        }

        // Fill up the right matrix
        for (int i = 0; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                }
            }
        }

        // Fill up the bottom matrix
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    bottom[i][j] = bottom[i + 1][j] + 1;
                }
            }
        }

        // Calculate the maximum cross size
        int maxArmLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int armLength = Math.min(Math.min(left[i][j], right[i][j]),
                        Math.min(top[i][j], bottom[i][j]));
                maxArmLength = Math.max(maxArmLength, armLength);
            }
        }

        return maxArmLength;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };

        System.out.println(largestCross(matrix));  // Output: 2
    }

}
