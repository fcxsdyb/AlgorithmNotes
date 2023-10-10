package LaiOffer.Class6_GraphSearchAlgorithms_II;

import java.util.ArrayList;

/**
 * DFS Question 2: Find all valid permutation using the provided parenthesis
 * <p>
 * Time Complexity = O(2^n)
 * Space Complexity = O(n) n is the number of parenthesis
 */
public class DFS_ValidParenthesisPermutation {

    public static void main(String[] args) {
        printValidParenthesis(3, 0, 0, new ArrayList<Character>());
    }

    private static void printValidParenthesis(int length, int left, int right, ArrayList<Character> res) {
        if (left == length && right == length) {
            System.out.println(new ArrayList<>(res));
            return;
        }

        if (left < length) {
            res.add('(');
            printValidParenthesis(length, left + 1, right, res);
            res.remove(res.size() - 1);
        }

        if (left > right) {
            res.add(')');
            printValidParenthesis(length, left, right + 1, res);
            res.remove(res.size() - 1);
        }
    }

}
