package LaiOffer.Class16_DynamicProgramming_III;

/**
 * DP question 2b: Given a Matrix that contains only 1s and Os, how to find the largest "X"
 * with the same arm lengths and the two arms join at the central point of each other.
 * <p>
 * Example:
 * 1 0 1 0
 * 1 1 1 1
 * 1 0 1 0
 * 0 1 0 0
 * return arm_length = 2
 */
public class DP_X1 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 0},
                {0, 1, 0, 0}
        };

        System.out.println(largestX(matrix));
    }

    private static int largestX(int[][] matrix) {
        return -1;
    }

}
