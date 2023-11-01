package LaiOffer.Class16_DynamicProgramming_III;

/**
 * DP Question 5:
 * Given a Matrix of integers (positive & negative numbers & 0s）, how to find the sub-matrix with the largest sum?
 * <p>
 * Example:
 * input:
 * 0 x x x x x x x x
 * x x x x x x x x x
 * x x x X x Z x x x
 * x x x W x Y x x x
 * x x x x x x x x x
 */
public class DP_SubMatrixLargestSum {

    /**
     * Thinking:
     * Solution 0 (primitive idea): how many sub-matrix are there in the input matrix??
     * size = n x n
     * Answer = O(n ^ 4)
     * Time of finding sum = O(n ^ 4 * n ^ 2) = O(n ^ 6)
     * <p>
     * Solution 1: Better idea, use 1D prefix sum
     * Calculate the prefix-sum in 1D, and then we can calculate the sum on each row in O(1) time.
     * Thus, the total time to calculate one possible matrix is O(n)
     * Totally, there are n^4 matrix, the total time = O(n ^ 5)
     * <p>
     * Solution 2: Better idea, use 2D prefix sum
     * <p>
     * [0][0]
     * 0  x  x  x  x  x          x x x
     * x  x  x  x  x  x          x x x
     * [i][j] [i][k]
     * x  x  x  X  x  Z          x x x
     * x  x  x  W  x  Y          x x x
     * [t][j] [t][k]
     * x  x  x  x  x  x
     * Sum[i][j] - [t][k] = [0][0]-[t][k] - [0][0]-[i-1][k] - [0][0]-[t][j-1] + [0][0]-[i-1][j-1]
     * <p>
     * How could we store the prefix sum for 2D space?
     * input =
     * 1 2 3 4 5
     * 1 2 1 2 1
     * 2 1 3 1 2
     * <p>
     * prefix-sum
     * 1  3  6 10 15
     * 2  6 10 16 22         Y[k][t] = [k-1][t] + prefix_sum_on_this_row
     * x  x  x  x  x
     * for i {
     * for j {
     * for k {
     * for t {
     * Sum[i][j] - [t][k] = [0][0]-[t][k] - [0][0]-[i-1][k] - [0][0]-[t][j-1] + [0][0]-[i-1][j-1]
     * }
     * }
     * }
     * }
     * Time = O(n ^ 4)
     * <p>
     * Solution 3 (Optimized idea, use Solution 0 + prefix_sum_1D)
     * x  x  x  x  x  x  x  x  x  x
     * x10 x11 x12 x13  x  x  x  x  x   up = 1 first we only consider all possible upper and lower bound
     * x20 x21 x22  x  x  x ...
     * x88 0 x88 1 x88 2  x  x  x ...   bottom row = 88
     * Compress for every single column which has n ^ 2 possible pair
     * S0 S1 S2 ... Sn-1   -> use it as the input of Question 0 (the largest sum subarray)
     * <p>
     * Total time = O(n ^ 2 * n) = O(n ^ 3)
     * pick upper/bottom rows
     */

    static int M = 4;
    static int N = 5;

    // Implementation of Kadane's algorithm for
    // 1D array. The function returns the maximum
    // sum and stores starting and ending indexes
    // of the maximum sum subarray at addresses
    // start and finish pointers respectively.
    static int kadane(int[] arr, int[] start, int[] finish, int n) {
        int sum = 0, maxSum = Integer.MIN_VALUE, i;

        finish[0] = -1;

        int local_start = 0;

        for (i = 0; i < n; ++i) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
                local_start = i + 1;
            } else if (sum > maxSum) {
                maxSum = sum;
                start[0] = local_start;
                finish[0] = i;
            }
        }

        // There is at-least one non-negative number
        if (finish[0] != -1)
            return maxSum;

        // Special Case: When all numbers in arr[] are negative
        maxSum = arr[0];
        start[0] = finish[0] = 0;

        for (i = 1; i < n; i++) {
            if (arr[i] > maxSum) {
                maxSum = arr[i];
                start[0] = finish[0] = i;
            }
        }
        return maxSum;
    }

    // The main function that finds maximum sum rectangle
    // in M[][][][]
    static void findMaxSum(int[][] M) {
        int maxSum = Integer.MIN_VALUE;
        int finalLeft = 0, finalRight = 0, finalTop = 0, finalBottom = 0;
        int left, right, i;
        int[] temp = new int[M.length];
        int[] sum = new int[M.length];
        int[] pos = new int[M.length];

        for (left = 0; left < N; ++left) {
            // Initialize all elements of temp as 0
            for (i = 0; i < M.length; ++i)
                temp[i] = 0;

            for (right = left; right < N; ++right) {
                // Find sum of every mini-row 'i' between
                // two columns by adding elements of maximum
                // sum rectangle of previous mini-row
                for (i = 0; i < M.length; ++i)
                    temp[i] += M[i][right];

                // Find the maximum sum subarray in temp[].
                // The kadane() function also sets values of
                // start and finish. So 'sum' is sum of
                // rectangle between (start, left) and
                // (finish, right) which is the maximum sum
                // with boundary columns strictly as left
                // and right.
                int sumTemp = kadane(temp, pos, sum, M.length);

                // Compare sum with maximum sum so far.
                // If sum is more, then update maxSum and
                // other output values
                if (sumTemp > maxSum) {
                    maxSum = sumTemp;
                    finalLeft = left;
                    finalRight = right;
                    finalTop = pos[0];
                    finalBottom = sum[0];
                }
            }
        }

        System.out.printf("(Top, Left) (%d, %d)\n", finalTop, finalLeft);
        System.out.printf("(Bottom, Right) (%d, %d)\n", finalBottom, finalRight);
        System.out.println("Max sum is: " + maxSum);
    }

    private static int kadane(int[] arr) {
        int maxCurrent = arr[0], maxGlobal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        return maxGlobal;
    }

    public static int findMaxSum1(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {
            int[] temp = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    temp[i] += matrix[i][right];
                }
                maxSum = Math.max(maxSum, kadane(temp));
            }
        }

        return maxSum;
    }

    // Driver Code
    public static void main(String[] args) {
        int M[][] = {
                {1, -12, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, -8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };

        //findMaxSum(M);
        System.out.println(findMaxSum1(M));
    }


}
