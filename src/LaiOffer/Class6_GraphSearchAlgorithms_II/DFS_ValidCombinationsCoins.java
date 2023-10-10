package LaiOffer.Class6_GraphSearchAlgorithms_II;

import java.util.Arrays;

/**
 * DFS Question 3: Find all combinations of coins that can sum up to a total value k
 * Total value k = 99 cents
 * coin value = 25 10 5 1 cent
 * <p>
 * Time Complexity = O(99^4)
 * Space Complexity = O(4)
 */
public class DFS_ValidCombinationsCoins {

    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1};
        printValidCombinations(coins, 99, 0, new int[4]);
    }

    private static void printValidCombinations(int[] coins, int target, int index, int[] res) {
        if (index == 3) {
            res[index] = target;
            System.out.println(Arrays.toString(res));
            return;
        }

        for (int i = 0; i * coins[index] < target; i++) {
            res[index] = i;
            printValidCombinations(coins, target - i * coins[index], index + 1, res);
        }
    }

}
