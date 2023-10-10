package Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BDQ2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        String[][] matrix = new String[row][column];

        in.nextLine();
        for (int i = 0; i < row; i++) {
            String[] tempRow = in.nextLine().split(" ");
            System.arraycopy(tempRow, 0, matrix[i], 0, tempRow.length);
        }

        int length = in.nextInt();
        int[] res = new int[length];
        in.nextLine();
        for (int i = 0; i < length; i++) {
            Map<String, Integer> record = new HashMap<>();
            int checkRow1 = in.nextInt();
            int checkCol1 = in.nextInt();
            int checkRow2 = in.nextInt();
            int checkCol2 = in.nextInt();
            for (int j = checkRow1 - 1; j < checkRow2; j++) {
                for (int k = checkCol1 - 1; k < checkCol2; k++) {
                    record.put(matrix[j][k], 1);
                    if (record.size() == 3) break;
                }
            }
            res[i] = record.size();
        }

        for (Integer result : res) {
            System.out.println(result);
        }
    }
}
