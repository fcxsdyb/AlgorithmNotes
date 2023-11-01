package LaiOffer.Class14_DynamicProgramming_II;

/**
 * DP question 2:
 * Given two strings of alphanumeric characters, determine the minimum number of
 * Replace, Delete, and Insert operations needed to transform one string into the other.
 */
public class DP_EditDistance {

    public static void main(String[] args) {
        String word1 = "sdfb";
        String word2 = "dffffb";
        System.out.println(editDistance1(word1, word2));
        System.out.println(editDistance2(word1, word2));
    }

    /**
     * Solution 1: Recursion
     * <p>
     * In the worst case, there are 2n levels in the recursion tree.
     * Time Complexity = O(4 ^ 2n) very bad
     */
    private static int editDistance1(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        }
        if (word2.isEmpty()) {
            return word1.length();
        }

        // four possible operation
        int ignore = Integer.MAX_VALUE;
        if (word1.charAt(0) == word2.charAt(0)) {
            ignore = editDistance1(word1.substring(1), word2.substring(1));
        }
        int replace = 1 + editDistance1(word1.substring(1), word2.substring(1));
        int delete = 1 + editDistance1(word1.substring(1), word2);
        int insert = 1 + editDistance1(word1, word2.substring(1));

        return min(ignore, replace, delete, insert);
    }

    private static int min(int ignore, int replace, int delete, int insert) {
        int min = Integer.MAX_VALUE;

        if (ignore < min) {
            min = ignore;
        }
        if (replace < min) {
            min = replace;
        }
        if (delete < min) {
            min = delete;
        }
        if (insert < min) {
            min = insert;
        }


        return min;
    }

    /**
     * Solution 2: DP
     * <p>
     * M[i][j]
     * =
     * case 0: M[i-1][j-1]         if s1[i-1] = s2[j-1]
     * min of {
     * case 1: 1 + M[i-1][j-1]     //replace
     * case 2: 1 + M[i-1][j]       //delete
     * case 3: 1 + M[i][j-1]       //insert
     * }
     * <p>
     * Time Complexity = O(m x n)
     * Space Complexity = O(m x n)
     */
    private static int editDistance2(String word1, String word2) {
        int[][] res = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = i;
        }
        for (int i = 0; i < res[0].length; i++) {
            res[0][i] = i;
        }

        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    res[i][j] = 1 + Math.min(res[i - 1][j - 1], Math.min(res[i - 1][j], res[i][j - 1]));
                }
            }
        }

        return res[word1.length()][word2.length()];
    }


}
