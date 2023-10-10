package ClassicalProblem;

public class Search2DMatrix_Binary {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length, column = matrix[0].length;
        int length = row * column;

        int start = 0, end = length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int num = matrix[mid / column][mid % column];
            if (num == target) {
                return true;
            } else if (num < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start / column][start % column] == target) {
            return true;
        } else if (matrix[end / column][end % column] == target) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 35, 36, 50}
        };
        System.out.println(searchMatrix(matrix, 50));
    }

}
