package LaiOffer.Class20_Midterm;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 1: Find all valid ways of putting N Queens on an N*N chessboard so that no two Queens can attack each other
 * (two queens can attack each other if they are on the same row/column or same diagonal line).
 * <p>
 * You can define your own way of how lo print the solution
 * e.g. using a size N array/list to record which column the queen occupies on each row.
 */
public class NQueens {

    public static void main(String[] args) {
        findNQueens(8);
        findNQueens(4);
    }

    private static void findNQueens(int num) {
        if (num <= 0) {
            System.out.println("Input is not valid.");
        }
        checkValidNQueens(0, num, new ArrayList<>());
    }

    private static void printRes(List<Integer> res, int num) {
        System.out.println(res);
        for (Integer result : res) {
            for (int i = 0; i < num; i++) {
                if (i == result) {
                    System.out.print(" Q");
                } else {
                    System.out.print(" X");
                }
            }
            System.out.println();
        }
    }

    private static void checkValidNQueens(int level, int num, List<Integer> temp) {
        if (level == num) {
            printRes(temp, num);
            return;
        }

        for (int i = 0; i < num; i++) {
            if (checkValid(i, temp)) {
                temp.add(i);
                checkValidNQueens(level + 1, num, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean checkValid(int level, List<Integer> temp) {
        for (int i = 0; i < temp.size(); i++) {
            if (level == temp.get(i) || Math.abs(temp.get(i) - level) == temp.size() - i) {
                return false;
            }
        }
        return true;
    }

}
