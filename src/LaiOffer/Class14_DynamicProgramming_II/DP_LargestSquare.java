package LaiOffer.Class14_DynamicProgramming_II;

/**
 * DP question 3: Largest square of 1's in a binary matrix
 * What is the edge length of the largest square of 1's in a given binary matrix.
 * In this case, your solution should return 3 (3x3 square).
 * 0 0 0 0 0
 * 1 1 1 1 0
 * 1 1 1 1 0
 * 1 1 1 0 0
 * 1 1 1 0 0
 */
public class DP_LargestSquare {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0}
        };

        System.out.println(largestSquare(matrix));
    }

    private static int largestSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int maxEdge = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    }
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }

        return maxEdge;
    }

}
