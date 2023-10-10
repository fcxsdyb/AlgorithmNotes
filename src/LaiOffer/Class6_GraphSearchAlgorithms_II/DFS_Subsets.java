package LaiOffer.Class6_GraphSearchAlgorithms_II;

import java.util.ArrayList;

/**
 * DFS Question 1: Print all subsets of a set S = {'a', 'b', 'c'}
 * <p>
 * Time Complexity = O(2^n)
 * Space Complexity = O(n)
 */
public class DFS_Subsets {

    public static void main(String[] args) {
        String input = "abc";
        char[] sets = input.toCharArray();
        printSubsets(sets, 0, sets.length, new ArrayList<Character>());
    }

    private static void printSubsets(char[] sets, int index, int length, ArrayList<Character> res) {
        if (index == length) {
            System.out.println(new ArrayList<>(res));
            return;
        }

        res.add(sets[index]);
        printSubsets(sets, index + 1, length, res);
        res.remove(res.size() - 1);
        printSubsets(sets, index + 1, length, res);
    }

}
