package LaiOffer.Class2_Recursion_I_BinarySearch;

/**
 * Apply binary search in 2D space
 * <p>
 * Variant 1.0 application: 2D matrix, sorted on each row.
 * first element of next row is larger（or equal） to the last element of previous row.
 * Now giving a target number, returning the position that the target locates within the matrix.
 * <p>
 * Time Complexity = O(log n)
 * Space Complexity = O(1)
 */
public class BinarySearch_2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {6, 7, 8, 9},
                {11, 13, 15, 16}
        };

        System.out.println(binarySearch2DMatrix(matrix, 12));
        System.out.println(binarySearch2DMatrix(matrix, 13));
    }

    private static int binarySearch2DMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        int start = 0;
        int end = matrix.length * matrix[0].length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midX = mid / matrix[0].length;
            int midY = mid % matrix[0].length;

            if (matrix[midX][midY] == target) {
                return mid;
            } else if (matrix[midX][midY] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
